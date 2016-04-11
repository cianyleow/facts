package com.ic.ee.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.MapBindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.ic.ee.core.jdbc.api.SubmissionDAO;
import com.ic.ee.core.validator.SubmissionFileValidator;
import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.SubmissionFileValidationException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.common.file.SubmissionFile;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.course.assignment.submission.SubmissionStatus;
import com.ic.ee.service.api.FileRequirementService;
import com.ic.ee.service.api.FileService;
import com.ic.ee.service.api.SubmissionService;
import com.ic.ee.util.ElementExtractor;

public class SimpleSubmissionService implements SubmissionService {

	private final SubmissionDAO submissionDAO;

	private final FileRequirementService fileRequirementService;

	private final FileService fileService;

	private final SubmissionFileValidator submissionFileValidator;

	public SimpleSubmissionService(SubmissionDAO submissionDAO, FileRequirementService fileRequirementService, FileService fileService, SubmissionFileValidator submissionFileValidator) {
		this.submissionDAO = submissionDAO;
		this.fileRequirementService = fileRequirementService;
		this.fileService = fileService;
		this.submissionFileValidator = submissionFileValidator;
	}

	@Override
	public Submission createSubmission(Integer assignmentId, Submission submission, String username) throws NoResultsReturnedException, TooManyResultsReturnedException {
		// Set status to created - i.e. not valid yet
		submission.setSubmissionStatus(SubmissionStatus.CREATED);

		// Get submission ID
		Integer submissionId = submissionDAO.createSubmission(assignmentId, username, submission);

		// Request whole new object from DB (including creationTime)
		return getSubmission(submissionId);
	}

	@Override
	public Submission getSubmission(Integer submissionId) throws NoResultsReturnedException, TooManyResultsReturnedException {
		List<Submission> submissions = submissionDAO.getSubmission(Collections.singletonList(submissionId));
		return ElementExtractor.extractOne(submissions);
	}

	@Override
	public File createSubmissionFile(Integer submissionId, Integer fileRequirementId, MultipartFile file, String username) throws IncorrectFileNameFormatException, FileUploadException, HashingException, SubmissionFileValidationException, NoResultsReturnedException, TooManyResultsReturnedException {
		SubmissionFile submissionFile = new SubmissionFile(file, fileRequirementService.getFileRequirement(fileRequirementId));
		Map<String, String> map = new HashMap<String, String>();
		MapBindingResult errors = new MapBindingResult(map, SubmissionFile.class.getName());
		submissionFileValidator.validate(submissionFile, errors);
		if(errors.hasErrors()) {
			throw new SubmissionFileValidationException(errors.getAllErrors());
		}
		File createdFile = fileService.createFile(file, username);
		return createdFile;
	}

	@Override
	public Submission validateSubmission(Integer submissionId, Submission submission) {
		// TODO Auto-generated method stub
		return null;
	}
}
