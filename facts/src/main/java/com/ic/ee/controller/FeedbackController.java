package com.ic.ee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.feedback.comment.Comment;
import com.ic.ee.domain.common.feedback.mark.Mark;
import com.ic.ee.service.api.FeedbackService;

@RestController
public class FeedbackController {

	@Autowired FeedbackService feedbackService;

	@RequestMapping(path = "/feedback/{feedbackId}", method = RequestMethod.GET)
	public Feedback getFeedback(@PathVariable("feedbackId") Integer feedbackId) {
		return feedbackService.getLiteFeedback(feedbackId);
	}

	@RequestMapping(path = "/feedback/{feedbackId}/comments", method = RequestMethod.GET)
	public List<Comment> getComments(@PathVariable("feedbackId") Integer feedbackId) {
		return feedbackService.getFeedback(feedbackId).getComments();
	}

	@RequestMapping(path = "/feedback/{feedbackId}/marks", method = RequestMethod.GET)
	public List<Mark> getMarks(@PathVariable("feedbackId") Integer feedbackId) {
		return feedbackService.getFeedback(feedbackId).getMarks();
	}
}
