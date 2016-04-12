package com.ic.ee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.service.api.FeedbackService;
import com.ic.ee.service.api.FileService;
import com.ic.ee.service.api.SubmissionService;

@RestController
public class SubmissionController {

	@Autowired
	private SubmissionService submissionService;

	@Autowired
	private FileService fileService;

	@Autowired
	private FeedbackService feedbackService;

	@RequestMapping(path = "/submissions/{submissionId}", method = RequestMethod.GET)
	public Submission getSubmission(@PathVariable("submissionId") Integer submissionId) throws NoResultsReturnedException, TooManyResultsReturnedException {
		return submissionService.getSubmission(submissionId);
	}

	@RequestMapping(path = "/submissions/{submissionId}/submissionFiles", method = RequestMethod.GET)
	public List<File> getSubmissionFiles(@PathVariable("submissionId") Integer submissionId) {
		return fileService.getSubmissionFiles(submissionId);
	}

	@RequestMapping(path = "/submissions/{submissionId}/feedback", method = RequestMethod.GET)
	public Feedback getFeedback(@PathVariable("submissionId") Integer submissionId) {
		return feedbackService.getSubmissionFeedback(submissionId);
	}

}
