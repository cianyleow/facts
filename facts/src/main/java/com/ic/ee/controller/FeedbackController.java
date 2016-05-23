package com.ic.ee.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.ic.ee.domain.Views;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.feedback.comment.Comment;
import com.ic.ee.service.api.FeedbackService;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	@JsonView(Views.Marker.class)
	@PreAuthorize("hasRole('ROLE_MARKER')")
	@RequestMapping(path = "/feedback/{feedbackId}", method = RequestMethod.GET)
	public Feedback getFeedback(@PathVariable("feedbackId") Integer feedbackId) {
		return feedbackService.getFeedback(feedbackId);
	}

	@JsonView(Views.Marker.class)
	@PreAuthorize("hasRole('ROLE_MARKER')")
	@RequestMapping(path = "/feedback/{feedbackId}", method = RequestMethod.PUT)
	public Feedback updateFeedback(@PathVariable("feedbackId") Integer feedbackId, @RequestBody Feedback feedback) {
		feedback.setFeedbackId(feedbackId);
		return feedbackService.updateFeedback(feedback);
	}

	@PreAuthorize("hasRole('ROLE_MARKER')")
	@RequestMapping(path = "/feedback/{feedbackId}", method = RequestMethod.DELETE)
	public void deleteFeedback(@PathVariable("feedbackId") Integer feedbackId) {
		feedbackService.deleteFeedback(feedbackId);
	}

	@JsonView(Views.Marker.class)
	@PreAuthorize("hasRole('ROLE_MARKER')")
	@RequestMapping(path = "/feedback/{feedbackId}/comments", method = RequestMethod.POST)
	public Comment createComment(@PathVariable("feedbackId") Integer feedbackId, @RequestBody Comment comment, Principal user) {
		return feedbackService.createComment(feedbackId, comment, user.getName());
	}

	@JsonView(Views.Marker.class)
	@PreAuthorize("hasRole('ROLE_MARKER')")
	@RequestMapping(path = "/comments/{commentId}", method = RequestMethod.GET)
	public Comment getComment(@PathVariable("commentId") Integer commentId) {
		return feedbackService.getComment(commentId);
	}

	@JsonView(Views.Marker.class)
	@PreAuthorize("hasRole('ROLE_MARKER')")
	@RequestMapping(path = "/comments/{commentId}", method = RequestMethod.PUT)
	public Comment updateComment(@PathVariable("commentId") Integer commentId, @RequestBody Comment comment) {
		comment.setCommentId(commentId);
		return feedbackService.updateComment(comment);
	}

	@PreAuthorize("hasRole('ROLE_MARKER')")
	@RequestMapping(path = "/comments/{commentId}", method = RequestMethod.DELETE)
	public void deleteComment(@PathVariable("commentId") Integer commentId) {
		feedbackService.deleteComment(commentId);
	}
}
