package com.ic.ee.domain.common.feedback;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ic.ee.domain.common.feedback.comment.Comment;
import com.ic.ee.domain.common.feedback.comment.CommentStatus;
import com.ic.ee.domain.common.feedback.mark.MarkStatus;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.user.marker.Marker;
import com.ic.ee.util.collection.CollectionUtil;
import com.ic.ee.util.collection.Includer;

public class Feedback {

	private Integer feedbackId;

	private Submission submission;

	private List<Comment> comments;
	private CommentStatus commentStatus;
	private Boolean commentReleased;

	private Double mark;
	private MarkStatus markStatus;
	private Boolean markReleased;

	private Marker marker;

	private Timestamp dueTime;

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

	@JsonIgnore
	public CommentStatus getCommentStatus() {
		return commentStatus;
	}

	public void setCommentStatus(CommentStatus commentStatus) {
		this.commentStatus = commentStatus;
	}

	public Boolean getCommentReleased() {
		return commentReleased;
	}

	public void setCommentReleased(Boolean commentReleased) {
		this.commentReleased = commentReleased;
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

	@JsonIgnore
	public MarkStatus getMarkStatus() {
		return markStatus;
	}

	public void setMarkStatus(MarkStatus markStatus) {
		this.markStatus = markStatus;
	}

	public Boolean getMarkReleased() {
		return markReleased;
	}

	public void setMarkReleased(Boolean markReleased) {
		this.markReleased = markReleased;
	}

	@JsonIgnore
	public List<Comment> getPublicComments() {
		if(comments == null || comments.isEmpty()) {
			return Collections.emptyList();
		}
		return CollectionUtil.filterElements(comments, new Includer<Comment, Boolean>() {
			@Override
			public Boolean include(Comment element) {
				return !element.getSecret();
			}
		});
	}

	public Timestamp getDueTime() {
		return dueTime;
	}

	public void setDueTime(Timestamp dueTime) {
		this.dueTime = dueTime;
	}
}
