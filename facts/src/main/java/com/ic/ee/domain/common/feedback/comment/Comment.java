package com.ic.ee.domain.common.feedback.comment;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.user.marker.Marker;

public class Comment {

	private Integer commentId;

	private Feedback feedback;

	private Boolean secret;

	private String comment;
	private Timestamp creationTime;

	private Marker author;

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	@JsonIgnore
	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public Boolean getSecret() {
		return secret;
	}

	public void setSecret(Boolean secret) {
		this.secret = secret;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	@JsonIgnore
	public Marker getAuthor() {
		return author;
	}

	public void setAuthor(Marker author) {
		this.author = author;
	}

	public static String[] getHeaders() {
		return new String[]{
			"Comment ID",
			"Feedback ID",
			"Secret",
			"Comment"
		};
	}

	public static String[] getAccessors() {
		return new String[] {
				"commentId",
				"feedback.feedbackId",
				"secret",
				"comment"
		};
	}
}
