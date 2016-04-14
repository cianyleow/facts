package com.ic.ee.service.api;

import com.ic.ee.domain.common.feedback.Feedback;

public interface FeedbackService {

	public Feedback getLiteFeedback(Integer feedbackId);

	public Feedback getSubmissionFeedback(Integer submissionId);

	public Feedback createFeedback(Integer submissionId, String username);

	public Feedback getFeedback(Integer feedbackId);

}
