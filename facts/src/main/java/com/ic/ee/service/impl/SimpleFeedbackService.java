package com.ic.ee.service.impl;

import com.ic.ee.core.dao.api.CommentDAO;
import com.ic.ee.core.dao.api.FeedbackDAO;
import com.ic.ee.core.dao.api.MarkDAO;
import com.ic.ee.core.dao.api.MarkerDAO;
import com.ic.ee.core.dao.api.SubmissionDAO;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.feedback.comment.Comment;
import com.ic.ee.domain.common.feedback.comment.CommentStatus;
import com.ic.ee.domain.common.feedback.mark.Mark;
import com.ic.ee.domain.common.feedback.mark.MarkStatus;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.user.marker.Marker;
import com.ic.ee.service.api.FeedbackService;

public class SimpleFeedbackService implements FeedbackService {

	private final FeedbackDAO feedbackDAO;

	private final SubmissionDAO submissionDAO;

	private final MarkDAO markDAO;

	private final CommentDAO commentDAO;

	private final MarkerDAO markerDAO;

	public SimpleFeedbackService(FeedbackDAO feedbackDAO, SubmissionDAO submissionDAO, MarkDAO markDAO, CommentDAO commentDAO, MarkerDAO markerDAO) {
		this.feedbackDAO = feedbackDAO;
		this.submissionDAO = submissionDAO;
		this.markDAO = markDAO;
		this.commentDAO = commentDAO;
		this.markerDAO = markerDAO;
	}

	@Override
	public Feedback getSubmissionFeedback(Integer submissionId) {
		return feedbackDAO.getFeedback(new Submission(submissionId));
	}

	@Override
	public Feedback createFeedback(Integer submissionId, String username) {
		Feedback feedback = new Feedback();
		feedback.setSubmission(new Submission(submissionId));

		feedback.setMarker(new Marker(username));

		feedback.setCommentStatus(CommentStatus.COMMENT_PENDING);
		feedback.setMarkStatus(MarkStatus.MARKS_PENDING);

		return feedbackDAO.create(feedback);
	}

	@Override
	public Feedback getLiteFeedback(Integer feedbackId) {
		return feedbackDAO.one(feedbackId);
	}

	@Override
	public Feedback updateFeedback(Feedback feedback) {
		return feedbackDAO.update(feedback);
	}

	@Override
	public void deleteFeedback(Integer feedbackId) {
		if(feedbackDAO.delete(feedbackId)) {
			// Successful...?
		}
	}

	@Override
	public Feedback getFeedback(Integer feedbackId) {
		Feedback feedback = feedbackDAO.one(feedbackId);
		decorateFeedback(feedback);
		return feedback;
	}

	private void decorateFeedback(Feedback feedback) {
		// Decorate submission
		feedback.setSubmission(submissionDAO.one(feedback.getSubmission().getSubmissionId()));

		// Decorate marks
		feedback.setMarks(markDAO.getMarks(feedback));

		// Decorate comments
		feedback.setComments(commentDAO.getComments(feedback));
	}

	@Override
	public Comment getComment(Integer commentId) {
		Comment comment = commentDAO.one(commentId);
		decorateComment(comment);
		return comment;
	}

	private void decorateComment(Comment comment) {
		// Decorate author
		comment.setAuthor(markerDAO.one(comment.getAuthor().getUserName()));
	}

	@Override
	public Comment getLiteComment(Integer commentId) {
		return commentDAO.one(commentId);
	}

	@Override
	public Mark getLiteMark(Integer markId) {
		return markDAO.one(markId);
	}

	@Override
	public Comment createComment(Comment comment) {
		return commentDAO.create(comment);
	}

	@Override
	public Comment updateComment(Comment comment) {
		return commentDAO.update(comment);
	}

	@Override
	public void deleteComment(Integer commentId) {
		if(commentDAO.delete(commentId)) {
			// Deleted successfully...
		}
	}

	@Override
	public Mark getMark(Integer markId) {
		return markDAO.one(markId);
	}

	@Override
	public Mark createMark(Mark mark) {
		return markDAO.create(mark);
	}

	@Override
	public Mark updateMark(Mark mark) {
		return markDAO.update(mark);
	}

	@Override
	public void deleteMark(Integer markId) {
		if(markDAO.delete(markId)) {

		}
	}
}
