package com.ic.ee.service.api;

import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.feedback.comment.Comment;

public interface FeedbackService {

	public Feedback getLiteFeedback(Integer feedbackId);

	public Feedback getFeedback(Integer feedbackId);

	public Feedback createFeedback(Integer submissionId, String username);

	public Feedback updateFeedback(Feedback feedback);

	public void deleteFeedback(Integer feedbackId);

	public Comment getLiteComment(Integer commentId);

	public Comment getComment(Integer commentId);

	public Comment createComment(Integer feedbackId, Comment comment, String username);

	public Comment updateComment(Comment comment);

	public void deleteComment(Integer commentId);

	public Feedback getSubmissionFeedback(Integer submissionId);
}
