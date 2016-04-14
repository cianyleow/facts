package com.ic.ee.service.impl;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ic.ee.core.dao.api.AssignmentDAO;
import com.ic.ee.core.dao.api.FileDAO;
import com.ic.ee.core.dao.api.FileRequirementDAO;
import com.ic.ee.core.dao.api.MarkComponentDAO;
import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.domain.common.feedback.mark.MarkComponent;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.common.file.FileRequirement;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.service.api.AssignmentService;
import com.ic.ee.service.api.FileRequirementService;
import com.ic.ee.service.api.FileService;
import com.ic.ee.service.api.MarkComponentService;

public class SimpleAssignmentService implements AssignmentService {

	private final AssignmentDAO assignmentDAO;

	private final MarkComponentDAO markComponentDAO;

	private final FileRequirementDAO fileRequirementDAO;

	private final FileDAO fileDAO;

	private final MarkComponentService markComponentService;

	private final FileRequirementService fileRequirementService;

	private final FileService fileService;

	public SimpleAssignmentService(AssignmentDAO assignmentDAO, MarkComponentDAO markComponentDAO,
			FileRequirementDAO fileRequirementDAO, FileDAO fileDAO, MarkComponentService markComponentService,
			FileRequirementService fileRequirementService, FileService fileService) {
		this.assignmentDAO = assignmentDAO;
		this.markComponentDAO = markComponentDAO;
		this.fileRequirementDAO = fileRequirementDAO;
		this.fileDAO = fileDAO;
		this.markComponentService = markComponentService;
		this.fileRequirementService = fileRequirementService;
		this.fileService = fileService;
	}

	@Override
	public Assignment getAssignment(Integer assignmentId, boolean lite) {
		Assignment assignment = assignmentDAO.one(assignmentId);
		if(!lite) {
			decorateAssignment(assignment);
		}
		return assignment;
	}

	@Override
	public Assignment createAssignment(Integer courseId, Assignment assignment) {
		// Decorate assignment with courseId

		// Create assignment, get persisted object
		assignment = assignmentDAO.create(assignment);

		// Save markComponents
		List<MarkComponent> markComponents = markComponentService.createMarkComponents(assignment.getAssignmentId(), assignment.getMarkComponents());
		assignment.setMarkComponents(markComponents);

		// Save requiredFiles
		List<FileRequirement> requiredFiles = fileRequirementService.createFileRequirements(assignment.getAssignmentId(), assignment.getRequiredFiles());
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

		// Decorate markComponents
		assignment.setMarkComponents(markComponentDAO.getMarkComponents(assignment.getAssignmentId()));
		// Decorate suppliedFiles
		assignment.setSuppliedFiles(fileDAO.getAssignmentFiles(assignment.getAssignmentId()));
		// Decorate requiredFiles
		assignment.setRequiredFiles(fileRequirementDAO.getFileRequirements(assignment.getAssignmentId()));
		// Decorate submissions

	}
}
