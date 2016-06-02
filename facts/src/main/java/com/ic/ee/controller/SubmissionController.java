package com.ic.ee.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.ic.ee.domain.Views;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.feedback.comment.Comment;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.service.api.FeedbackService;
import com.ic.ee.service.api.SubmissionService;

@RestController
public class SubmissionController {

	@Autowired
	private SubmissionService submissionService;

	@Autowired
	private FeedbackService feedbackService;

	@JsonView(Views.Student.class)
	@RequestMapping(path = "/submissions/{submissionId}", method = RequestMethod.GET)
	public Submission getSubmission(@PathVariable("submissionId") Integer submissionId) {
		return submissionService.getSubmission(submissionId);
	}

	@JsonView(Views.Student.class)
	@RequestMapping(path = "/submissions/{submissionId}/feedback/{feedbackId}/comments", method = RequestMethod.GET)
	public List<Comment> getPublicComments(@PathVariable("feedbackId") Integer feedbackId) {
		return feedbackService.getFeedback(feedbackId).getPublicComments();

	}

	@JsonView(Views.Marker.class)
	@RequestMapping(path = "/submissions/{submissionId}/feedback", method = RequestMethod.POST)
	public Feedback createFeedback(@PathVariable("submissionId") Integer submissionId, Principal user) {
		return feedbackService.createFeedback(submissionId, user.getName());
	}

	@JsonView(Views.Public.class)
	@RequestMapping(path = "/submissions/{submissionId}/assignment", method = RequestMethod.GET)
	public Assignment getAssignment(@PathVariable("submissionId") Integer submissionId) {
		return submissionService.getSubmission(submissionId).getAssignment();
	}
}
