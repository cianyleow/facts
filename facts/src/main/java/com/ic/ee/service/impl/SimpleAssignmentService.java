package com.ic.ee.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ic.ee.core.dao.api.AssignmentDAO;
import com.ic.ee.core.dao.api.CourseDAO;
import com.ic.ee.core.dao.api.FileDAO;
import com.ic.ee.core.dao.api.FileRequirementDAO;
import com.ic.ee.core.dao.api.MarkComponentDAO;
import com.ic.ee.core.dao.api.SubmissionDAO;
import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.domain.common.feedback.mark.MarkComponent;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.common.file.FileRequirement;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.service.api.AssignmentService;
import com.ic.ee.service.api.FileService;

public class SimpleAssignmentService implements AssignmentService {

	private final AssignmentDAO assignmentDAO;

	private final MarkComponentDAO markComponentDAO;

	private final FileRequirementDAO fileRequirementDAO;

	private final SubmissionDAO submissionDAO;

	private final FileDAO fileDAO;

	private final CourseDAO courseDAO;

	private final FileService fileService;

	public SimpleAssignmentService(AssignmentDAO assignmentDAO, MarkComponentDAO markComponentDAO,
			FileRequirementDAO fileRequirementDAO, SubmissionDAO submissionDAO, FileDAO fileDAO, CourseDAO courseDAO,
			FileService fileService) {
		this.assignmentDAO = assignmentDAO;
		this.markComponentDAO = markComponentDAO;
		this.fileRequirementDAO = fileRequirementDAO;
		this.submissionDAO = submissionDAO;
		this.fileDAO = fileDAO;
		this.courseDAO = courseDAO;
		this.fileService = fileService;
	}

	@Override
	public Assignment getLiteAssignment(Integer assignmentId) {
		return assignmentDAO.one(assignmentId);
	}

	@Override
	public Assignment getAssignment(Integer assignmentId) {
		Assignment assignment = assignmentDAO.one(assignmentId);
		decorateAssignment(assignment);
		return assignment;
	}

	@Override
	public Assignment createAssignment(Integer courseId, Assignment assignment) {
		// Decorate assignment with courseId
		assignment.setCourse(new Course(courseId));

		// Create assignment, get persisted object
		assignment = assignmentDAO.create(assignment);


		// Save markComponents
		List<MarkComponent> markComponents = new ArrayList<MarkComponent>();
		for(MarkComponent markComponent : assignment.getMarkComponents()) {
			markComponent.setAssignment(assignment);
			MarkComponent _markComponent = markComponentDAO.create(markComponent);
			_markComponent.setAssignment(assignment);
			markComponents.add(_markComponent);
		}
		assignment.setMarkComponents(markComponents);

		// Save requiredFiles
		List<FileRequirement> requiredFiles = new ArrayList<FileRequirement>();
		for(FileRequirement requiredFile : assignment.getRequiredFiles()) {
			requiredFile.setAssignment(assignment);
			FileRequirement _requiredFile = fileRequirementDAO.create(requiredFile);
			_requiredFile.setAssignment(assignment);
			requiredFiles.add(_requiredFile);
		}
		assignment.setRequiredFiles(requiredFiles);

		// Return decorated assignment
		return assignment;
	}

	@Override
	public File createSuppliedFile(Integer assignmentId, MultipartFile file, String username) throws IncorrectFileNameFormatException, FileUploadException, HashingException, NoResultsReturnedException {
		// Create file from multipart file
		File createdFile = fileService.createFile(file, username);

		// Create file/assignment link
		assignmentDAO.createAssignmentFile(assignmentId, createdFile);

		// Return file after link is created.
		return createdFile;
	}

	private void decorateAssignment(Assignment assignment) {
		// Decorate course
		Course course = courseDAO.one(assignment.getCourse().getCourseId());
		course.setAssignments(Collections.singletonList(assignment));
		assignment.setCourse(course);

		// Decorate markComponents
		List<MarkComponent> markComponents = markComponentDAO.getMarkComponents(assignment.getAssignmentId());
		for(MarkComponent markComponent : markComponents) {
			markComponent.setAssignment(assignment);
		}
		assignment.setMarkComponents(markComponents);

		// Decorate suppliedFiles
		List<File> suppliedFiles = fileDAO.getAssignmentFiles(assignment.getAssignmentId());
		assignment.setSuppliedFiles(suppliedFiles);

		// Decorate requiredFiles
		List<FileRequirement> fileRequirements = fileRequirementDAO.getFileRequirements(assignment.getAssignmentId());
		for(FileRequirement fileRequirement : fileRequirements) {
			fileRequirement.setAssignment(assignment);
		}
		assignment.setRequiredFiles(fileRequirements);

		// Decorate submissions
		List<Submission> submissions = submissionDAO.getSubmissions(assignment);
		for(Submission submission : submissions) {
			submission.setAssignment(assignment);
		}
	}
}
