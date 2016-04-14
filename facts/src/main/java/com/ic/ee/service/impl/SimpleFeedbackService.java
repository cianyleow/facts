package com.ic.ee.service.impl;

import com.ic.ee.core.dao.api.FeedbackDAO;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.service.api.FeedbackService;

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
	public Feedback createFeedback(Integer submissionId, String username) {
		// Create feedback and get ID back
		Integer feedbackId = feedbackDAO.createFeedback(submissionId, username);

		// Return object, without decorations
		return feedbackDAO.getFeedback(feedbackId);
	}

}
