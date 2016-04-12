package com.ic.ee.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ic.ee.core.dao.api.AssignmentDAO;
import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.feedback.mark.MarkComponent;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.common.file.FileRequirement;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.service.api.AssignmentService;
import com.ic.ee.service.api.FileRequirementService;
import com.ic.ee.service.api.FileService;
import com.ic.ee.service.api.MarkComponentService;
import com.ic.ee.util.ElementExtractor;

public class SimpleAssignmentService implements AssignmentService {

	private final AssignmentDAO assignmentDAO;

	private final MarkComponentService markComponentService;

	private final FileRequirementService fileRequirementService;

	private final FileService fileService;

	public SimpleAssignmentService(AssignmentDAO assignmentDAO, MarkComponentService markComponentService, FileRequirementService fileRequirementService, FileService fileService) {
		this.assignmentDAO = assignmentDAO;
		this.markComponentService = markComponentService;
		this.fileRequirementService = fileRequirementService;
		this.fileService = fileService;
	}

	@Override
	public Assignment getAssignment(Integer assignmentId) throws NoResultsReturnedException, TooManyResultsReturnedException {
		List<Assignment> assignments = assignmentDAO.getAssignments(Collections.singletonList(assignmentId));
		return ElementExtractor.extractOne(assignments);
	}

	@Override
	public List<Assignment> getAssignments(Integer courseId) {
		return assignmentDAO.getAssignments(courseId);
	}

	@Override
	public List<FileRequirement> getRequiredFiles(Integer assignmentId) {
		return assignmentDAO.getRequiredFiles(assignmentId);
	}

	@Override
	public List<MarkComponent> getMarkComponents(Integer assignmentId) {
		return assignmentDAO.getMarkComponents(assignmentId);
	}

	@Override
	public List<File> getSuppliedFiles(Integer assignmentId) {
		List<Integer> fileIds = assignmentDAO.getSuppliedFileIds(assignmentId);
		return fileService.getFiles(fileIds);
	}

	@Override
	public Assignment createAssignment(Integer courseId, Assignment assignment) {
		// Save assignment, get assignment ID
		Integer assignmentId = assignmentDAO.createAssignment(courseId, assignment);
		assignment.setAssignmentId(assignmentId);

		// Save markComponents
		List<MarkComponent> markComponents = markComponentService.createMarkComponents(assignmentId, assignment.getMarkComponents());
		assignment.setMarkComponents(markComponents);

		// Save requiredFiles
		List<FileRequirement> requiredFiles = fileRequirementService.createFileRequirements(assignmentId, assignment.getRequiredFiles());
		assignment.setRequiredFiles(requiredFiles);

		// Return decorated assignment
		return assignment;
	}

	@Override
	public File createSuppliedFile(Integer assignmentId, MultipartFile file, String username) throws IncorrectFileNameFormatException, FileUploadException, HashingException, NoResultsReturnedException, TooManyResultsReturnedException {
		// Create file from multipart file
		File createdFile = fileService.createFile(file, username);

		// Create file/assignment link
		assignmentDAO.createAssignmentFile(assignmentId, createdFile);

		// Return file after link is created.
		return createdFile;
	}
}
