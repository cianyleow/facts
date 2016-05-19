package com.ic.ee.domain.common.feedback;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ic.ee.domain.common.feedback.comment.Comment;
import com.ic.ee.domain.common.feedback.comment.CommentStatus;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.user.marker.Marker;

public class Feedback {

	private Integer feedbackId;

	private Submission submission;

	private List<Comment> comments;
	private CommentStatus commentStatus;

	private Double mark;

	private Marker marker;

	public Feedback() {}

	public Feedback(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

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
		if(comments == null) {
			this.comments = new ArrayList<Comment>();
		} else {
			this.comments = comments;
			for(Comment comment : this.comments) {
				comment.setFeedback(this);
			}
		}
	}

	public CommentStatus getCommentStatus() {
		return commentStatus;
	}

	public void setCommentStatus(CommentStatus commentStatus) {
		this.commentStatus = commentStatus;
	}

	@JsonIgnore
	public Marker getMarker() {
		return marker;
	}

	public void setMarker(Marker marker) {
		this.marker = marker;
	}

	@JsonIgnore
	public Double getMark() {
		return mark;
	}

	@JsonProperty
	public void setMark(Double mark) {
		this.mark = mark;
	}
}
