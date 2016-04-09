package com.ic.ee.service.impl;

import java.util.Collections;
import java.util.List;

import com.ic.ee.core.jdbc.api.SubmissionDAO;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.course.assignment.submission.SubmissionStatus;
import com.ic.ee.service.api.SubmissionService;
import com.ic.ee.util.ElementExtractor;

public class SimpleSubmissionService implements SubmissionService {

	private final SubmissionDAO submissionDAO;

	public SimpleSubmissionService(SubmissionDAO submissionDAO) {
		this.submissionDAO = submissionDAO;
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

}
