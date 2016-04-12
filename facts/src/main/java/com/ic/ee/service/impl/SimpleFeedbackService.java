package com.ic.ee.service.impl;

import java.util.Collections;
import java.util.List;

import com.ic.ee.core.dao.api.FeedbackDAO;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.service.api.FeedbackService;
import com.ic.ee.util.ElementExtractor;

public class SimpleFeedbackService implements FeedbackService {

	private final FeedbackDAO feedbackDAO;

	public SimpleFeedbackService(FeedbackDAO feedbackDAO) {
		this.feedbackDAO = feedbackDAO;
	}

	@Override
	public Feedback getSubmissionFeedback(Integer submissionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feedback createFeedback(Integer submissionId, String username) throws NoResultsReturnedException, TooManyResultsReturnedException {
		// Create feedback and get ID back
		Integer feedbackId = feedbackDAO.createFeedback(submissionId, username);
		// Return object, without decorations
		List<Feedback> feedback = feedbackDAO.getFeedback(Collections.singletonList(feedbackId));
		return ElementExtractor.extractOne(feedback);
	}

}
