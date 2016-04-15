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
	public Assignment createAssignment(Integer courseId, Assignment assignment, MultipartFile[] files, String username) throws IncorrectFileNameFormatException, FileUploadException, HashingException, NoResultsReturnedException {
		// Extract required files/mark components before saving.
		List<MarkComponent> markComponents = assignment.getMarkComponents();
		List<FileRequirement> requiredFiles = assignment.getRequiredFiles();

		// Decorate assignment with courseId
		assignment.setCourse(new Course(courseId));

		// Create assignment, get persisted object
		assignment = assignmentDAO.create(assignment);

		// Save markComponents
		List<MarkComponent> _markComponents = new ArrayList<MarkComponent>();
		for(MarkComponent markComponent : markComponents) {
			markComponent.setAssignment(assignment);
			_markComponents.add(markComponentDAO.create(markComponent));
		}
		assignment.setMarkComponents(_markComponents);

		// Save requiredFiles
		List<FileRequirement> _requiredFiles = new ArrayList<FileRequirement>();
		for(FileRequirement requiredFile : requiredFiles) {
			requiredFile.setAssignment(assignment);
			_requiredFiles.add(fileRequirementDAO.create(requiredFile));
		}
		assignment.setRequiredFiles(_requiredFiles);

		// Create/upload/link supplied files
		List<File> suppliedFiles = new ArrayList<File>();
		for(MultipartFile file : files) {
			suppliedFiles.add(createSuppliedFile(assignment.getAssignmentId(), file, username));
		}
		assignment.setSuppliedFiles(suppliedFiles);

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
		assignment.setMarkComponents(markComponentDAO.getMarkComponents(assignment.getAssignmentId()));

		// Decorate suppliedFiles
		assignment.setSuppliedFiles(fileDAO.getFiles(assignment));

		// Decorate requiredFiles
		assignment.setRequiredFiles(fileRequirementDAO.getFileRequirements(assignment.getAssignmentId()));

		// Decorate submissions
		assignment.setSubmissions(submissionDAO.getSubmissions(assignment));
	}
}
