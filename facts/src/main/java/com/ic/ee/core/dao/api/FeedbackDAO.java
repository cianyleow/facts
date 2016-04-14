package com.ic.ee.core.dao.api;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.common.feedback.Feedback;

public interface FeedbackDAO extends BaseDAO<Feedback, Integer> {

	public Integer createFeedback(Integer submissionId, String username);

	public Feedback getFeedback(Integer feedbackId);
}
