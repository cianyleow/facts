package com.ic.ee.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.MapBindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.ic.ee.core.dao.api.SubmissionDAO;
import com.ic.ee.core.validator.SubmissionFileValidator;
import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.SubmissionFileMatchException;
import com.ic.ee.core.web.exception.SubmissionFileValidationException;
import com.ic.ee.core.web.exception.UnmatchableSetsException;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.common.file.FileRequirement;
import com.ic.ee.domain.common.file.SubmissionFile;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.course.assignment.submission.SubmissionStatus;
import com.ic.ee.service.api.AssignmentService;
import com.ic.ee.service.api.FileService;
import com.ic.ee.service.api.SubmissionService;

public class SimpleSubmissionService implements SubmissionService {

	private final SubmissionDAO submissionDAO;

	private final AssignmentService assignmentService;

	private final FileService fileService;

	private final SubmissionFileValidator submissionFileValidator;

	public SimpleSubmissionService(SubmissionDAO submissionDAO, AssignmentService assignmentService,
			FileService fileService, SubmissionFileValidator submissionFileValidator) {
		this.submissionDAO = submissionDAO;
		this.assignmentService = assignmentService;
		this.fileService = fileService;
		this.submissionFileValidator = submissionFileValidator;
	}

	@Override
	public Submission createSubmission(Integer assignmentId, Submission submission, MultipartFile[] files, String username) throws NoResultsReturnedException, SubmissionFileMatchException, UnmatchableSetsException, SubmissionFileValidationException, IncorrectFileNameFormatException, FileUploadException, HashingException {
		// Generate submission creation time - before file uploads, to avoid slow internet issues
		submission.setCreationTime(new Date());

		// Get assignment
		Assignment assignment = assignmentService.getAssignment(assignmentId);

		// Compare dueTime and creationTime to determine status of submission.
		if(submission.getCreationTime().before(assignment.getDueTime())) {
			submission.setSubmissionStatus(SubmissionStatus.ONTIME);
		} else {
			submission.setSubmissionStatus(SubmissionStatus.LATE);
		}

		// Get file requirements
		List<FileRequirement> fileRequirements = assignment.getRequiredFiles();

		// Match all files up with the file requirements and validate - throw error if not complete/incorrect
		List<SubmissionFile> submissionFiles = matchSubmissionFiles(files, fileRequirements);
		Map<String, String> map = new HashMap<String, String>();
		MapBindingResult errors = new MapBindingResult(map, SubmissionFile.class.getName());
		for(SubmissionFile submissionFile : submissionFiles) {
			submissionFileValidator.validate(submissionFile, errors);
		}
		if(errors.hasErrors()) {
			throw new SubmissionFileValidationException(errors.getAllErrors());
		}

		// Decorate submission with details
		submission.setAssignment(assignment);

		// Create submission
		submission = submissionDAO.create(submission);

		// Attach files to submission
		createSubmissionFiles(submission.getSubmissionId(), files, username);

		// Return decorated submission from DB with submission ID
		return submission;
	}

	private void createSubmissionFiles(Integer submissionId, MultipartFile[] files, String username) throws IncorrectFileNameFormatException, FileUploadException, HashingException, NoResultsReturnedException {
		List<Integer> fileIds = new ArrayList<Integer>();
		for(MultipartFile file : files) {
			File createdFile = fileService.createFile(file, username);
			Integer fileId = createdFile.getFileId();
			fileIds.add(fileId);
			submissionDAO.createSubmissionFile(submissionId, fileId);
		}
	}

	private List<SubmissionFile> matchSubmissionFiles(MultipartFile[] files, List<FileRequirement> fileRequirements) throws SubmissionFileMatchException, UnmatchableSetsException {
		if((files == null && !fileRequirements.isEmpty()) || (files.length != fileRequirements.size())) {
			throw new UnmatchableSetsException();
		}

		List<SubmissionFile> submissionFiles = new ArrayList<SubmissionFile>();

		// Create an inverse map of fileRequirements to file names
		Map<String, FileRequirement> fileRequirementsMap = new HashMap<String, FileRequirement>();
		for(FileRequirement fileRequirement : fileRequirements) {
			fileRequirementsMap.put(fileRequirement.getFullAllowedFileName(), fileRequirement);
		}

		// Remove each map element by file original name
		for(MultipartFile file : files) {
			FileRequirement fileRequirement = fileRequirementsMap.remove(file.getOriginalFilename());
			if(fileRequirement == null) {
				throw new SubmissionFileMatchException(file);
			}
			submissionFiles.add(new SubmissionFile(file, fileRequirement));
		}

		return submissionFiles;
	}

	@Override
	public Submission getSubmission(Integer submissionId) {
		return submissionDAO.one(submissionId);
	}
}
