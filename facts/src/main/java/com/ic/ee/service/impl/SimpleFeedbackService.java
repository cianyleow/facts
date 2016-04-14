package com.ic.ee.service.impl;

import com.ic.ee.core.dao.api.FeedbackDAO;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.feedback.comment.CommentStatus;
import com.ic.ee.domain.common.feedback.mark.MarkStatus;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.user.marker.Marker;
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
		Feedback feedback = new Feedback();
		Submission submission = new Submission();
		submission.setSubmissionId(submissionId);
		feedback.setSubmission(submission);

		Marker marker = new Marker();
		marker.setUserName(username);
		feedback.setMarker(marker);

		feedback.setCommentStatus(CommentStatus.COMMENT_PENDING);
		feedback.setMarkStatus(MarkStatus.MARKS_PENDING);

		return feedbackDAO.create(feedback);
	}
}
