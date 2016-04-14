package com.ic.ee.core.dao.api;

import com.ic.ee.domain.common.feedback.Feedback;

public interface FeedbackDAO {

	public Integer createFeedback(Integer submissionId, String username);

	public Feedback getFeedback(Integer feedbackId);
}
