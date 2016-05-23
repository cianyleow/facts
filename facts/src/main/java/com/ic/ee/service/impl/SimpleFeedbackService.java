package com.ic.ee.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ic.ee.core.dao.api.CommentDAO;
import com.ic.ee.core.dao.api.FeedbackDAO;
import com.ic.ee.core.dao.api.MarkerDAO;
import com.ic.ee.core.dao.api.SubmissionDAO;
import com.ic.ee.core.web.exception.NoMarkersException;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.feedback.FeedbackStatus;
import com.ic.ee.domain.common.feedback.comment.Comment;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.user.marker.Marker;
import com.ic.ee.service.api.FeedbackService;
import com.ic.ee.service.api.SubmissionService;
import com.ic.ee.util.marker.Allocator;

public class SimpleFeedbackService implements FeedbackService {

	private final FeedbackDAO feedbackDAO;

	private final SubmissionDAO submissionDAO;

	private final CommentDAO commentDAO;

	private final MarkerDAO markerDAO;

	private final SubmissionService submissionService;

	public SimpleFeedbackService(FeedbackDAO feedbackDAO, SubmissionDAO submissionDAO, CommentDAO commentDAO, MarkerDAO markerDAO, SubmissionService submissionService) {
		this.feedbackDAO = feedbackDAO;
		this.submissionDAO = submissionDAO;
		this.commentDAO = commentDAO;
		this.markerDAO = markerDAO;
		this.submissionService = submissionService;
	}

	@Override
	public Feedback getSubmissionFeedback(Integer submissionId) {
		return feedbackDAO.getFeedback(new Submission(submissionId));
	}

	@Override
	public Feedback createFeedback(Integer submissionId, String username) {
		return createFeedback(new Submission(submissionId), new Marker(username));
	}

	private Feedback createFeedback(Submission submission, Marker marker) {
		Feedback feedback = new Feedback();
		feedback.setSubmission(submission);
		feedback.setMarker(marker);
		feedback.setFeedbackStatus(FeedbackStatus.QUEUED);
		feedback.setMark(0.0);
		feedback.setDueTime(new Timestamp(new Date().getTime() + 10 * 24 * 60 * 60 * 1000));
		feedback.setCommentReleased(false);
		feedback.setMarkReleased(false);
		return feedbackDAO.create(feedback);
	}

	@Override
	public List<Feedback> createFeedback(Integer assignmentId, Allocator allocator) throws NoMarkersException {
		List<Marker> markers = markerDAO.getMarkers(new Assignment(assignmentId));
		if(markers == null || markers.size() == 0) {
			throw new NoMarkersException();
		}
		List<Submission> submissions = submissionDAO.getSubmissions(new Assignment(assignmentId));
		List<Feedback> feedback = new ArrayList<Feedback>();
		for(Submission submission : submissions) {
			feedback.add(createFeedback(submission, allocator.getMarker(submission, markers)));
		}
		return feedback;
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
		feedback.setSubmission(submissionService.getSubmission(feedback.getSubmission().getSubmissionId()));

		// Decorate comments
		feedback.setComments(commentDAO.getComments(feedback));

		// Decorate marker
		feedback.setMarker(markerDAO.one(feedback.getMarker().getUserName()));
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
	public Comment createComment(Integer feedbackId, Comment comment, String username) {
		comment.setAuthor(new Marker(username));
		comment.setFeedback(new Feedback(feedbackId));
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
	public List<Feedback> getFeedback(String username) {
		return feedbackDAO.getFeedback(new Marker(username));
	}
}
