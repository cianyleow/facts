package com.ic.ee.core.dao.api;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.course.assignment.submission.Submission;

public interface FeedbackDAO extends BaseDAO<Feedback, Integer> {

	public Feedback getFeedback(Submission submission);

}
