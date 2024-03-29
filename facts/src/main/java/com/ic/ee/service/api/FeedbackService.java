package com.ic.ee.service.api;

import java.util.List;

import com.ic.ee.core.web.exception.NoMarkersException;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.feedback.comment.Comment;
import com.ic.ee.util.marker.Allocator;

public interface FeedbackService {

	public Feedback getFeedback(Integer feedbackId);

	public List<Feedback> getFeedback(String username);

	public Feedback createFeedback(Integer submissionId, String username);

	public List<Feedback> createFeedback(Integer assignmentId, Allocator allocator) throws NoMarkersException;

	public Feedback updateFeedback(Feedback feedback);

	public void deleteFeedback(Integer feedbackId);

	public Comment getComment(Integer commentId);

	public Comment createComment(Integer feedbackId, Comment comment, String username);

	public Comment updateComment(Comment comment);

	public void deleteComment(Integer commentId);

	public Feedback getSubmissionFeedback(Integer submissionId);
}
