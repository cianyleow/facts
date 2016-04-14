package com.ic.ee.domain.common.feedback;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ic.ee.domain.common.feedback.comment.Comment;
import com.ic.ee.domain.common.feedback.comment.CommentStatus;
import com.ic.ee.domain.common.feedback.mark.Mark;
import com.ic.ee.domain.common.feedback.mark.MarkStatus;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.user.marker.Marker;

public class Feedback {

	private Integer feedbackId;

	private Submission submission;

	private List<Comment> comments;
	private CommentStatus commentStatus;

	private List<Mark> marks;
	private MarkStatus markStatus;

	private Marker marker;

	public Feedback() {
		// TODO Auto-generated constructor stub
	}

	public Feedback(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	@JsonIgnore
	public Submission getSubmission() {
		return submission;
	}

	public void setSubmission(Submission submission) {
		this.submission = submission;
	}

	@JsonIgnore
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public CommentStatus getCommentStatus() {
		return commentStatus;
	}

	public void setCommentStatus(CommentStatus commentStatus) {
		this.commentStatus = commentStatus;
	}

	@JsonIgnore
	public List<Mark> getMarks() {
		return marks;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}

	public MarkStatus getMarkStatus() {
		return markStatus;
	}

	public void setMarkStatus(MarkStatus markStatus) {
		this.markStatus = markStatus;
	}

	@JsonIgnore
	public Marker getMarker() {
		return marker;
	}

	public void setMarker(Marker marker) {
		this.marker = marker;
	}
}
