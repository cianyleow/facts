package com.ic.ee.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.feedback.comment.Comment;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.user.marker.Marker;
import com.ic.ee.service.api.FeedbackService;

@RestController
public class FeedbackController {

	@Autowired FeedbackService feedbackService;

	@RequestMapping(path = "/feedback/{feedbackId}", method = RequestMethod.GET)
	public Feedback getFeedback(@PathVariable("feedbackId") Integer feedbackId) {
		return feedbackService.getLiteFeedback(feedbackId);
	}

	@RequestMapping(path = "/feedback/{feedbackId}", method = RequestMethod.PUT)
	public Feedback updateFeedback(@PathVariable("feedbackId") Integer feedbackId, @RequestBody Feedback feedback) {
		feedback.setFeedbackId(feedbackId);
		return feedbackService.updateFeedback(feedback);
	}

	@RequestMapping(path = "/feedback/{feedbackId}", method = RequestMethod.DELETE)
	public void deleteFeedback(@PathVariable("feedbackId") Integer feedbackId) {
		feedbackService.deleteFeedback(feedbackId);
	}

	@RequestMapping(path = "/feedback/{feedbackId}/submission", method = RequestMethod.GET)
	public Submission getSubmission(@PathVariable("feedbackId") Integer feedbackId) {
		return feedbackService.getFeedback(feedbackId).getSubmission();
	}

	@RequestMapping(path = "/feedback/{feedbackId}/marker", method = RequestMethod.GET)
	public Marker getMarker(@PathVariable("feedbackId") Integer feedbackId) {
		return feedbackService.getFeedback(feedbackId).getMarker();
	}

	@RequestMapping(path = "/feedback/{feedbackId}/comments", method = RequestMethod.GET)
	public List<Comment> getComments(@PathVariable("feedbackId") Integer feedbackId) {
		return feedbackService.getFeedback(feedbackId).getComments();
	}

	@RequestMapping(path = "/feedback/{feedbackId}/comments", method = RequestMethod.POST)
	public Comment createComment(@PathVariable("feedbackId") Integer feedbackId, @RequestBody Comment comment, Principal user) {
		return feedbackService.createComment(feedbackId, comment, user.getName());
	}

	@RequestMapping(path = "/feedback/{feedbackId}/comments/{commentId}", method = RequestMethod.GET)
	public Comment getComment(@PathVariable("feedbackId") Integer feedbackId, @PathVariable("commentId") Integer commentId) {
		return feedbackService.getLiteComment(commentId);
	}

	@RequestMapping(path = "/feedback/{feedbackId}/comments/{commentId}", method = RequestMethod.PUT)
	public Comment updateComment(@PathVariable("feedbackId") Integer feedbackId, @PathVariable("commentId") Integer commentId, @RequestBody Comment comment) {
		comment.setCommentId(commentId);
		return feedbackService.updateComment(comment);
	}

	@RequestMapping(path = "/feedback/{feedbackId}/comments/{commentId}", method = RequestMethod.DELETE)
	public void deleteComment(@PathVariable("feedbackId") Integer feedbackId, @PathVariable("commentId") Integer commentId) {
		feedbackService.deleteComment(commentId);
	}

	@RequestMapping(path = "/feedback/{feedbackId}/comments/{commentId}/marker", method = RequestMethod.GET)
	public Marker getAuthor(@PathVariable("feedbackId") Integer feedbackId, @PathVariable("commentId") Integer commentId) {
		return feedbackService.getComment(commentId).getAuthor();
	}
}
