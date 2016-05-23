package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.user.marker.Marker;

public interface FeedbackDAO extends BaseDAO<Feedback, Integer> {

	public Feedback getFeedback(Submission submission);

	public List<Feedback> getFeedback(Marker marker);

}
