package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.domain.common.feedback.Feedback;

public interface FeedbackDAO {

	public Integer createFeedback(Integer submissionId, String username);

	public List<Feedback> getFeedback(List<Integer> feedbackIds);
}
