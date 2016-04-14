package com.ic.ee.domain.common.feedback.comment;

import java.util.Date;

import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.user.marker.Marker;

public class Comment {

	private Integer commentId;

	private Feedback feedback;

	private Submission submission;

	private Boolean secret;

	private String comment;
	private Date creationTime;

	private Marker author;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public Submission getSubmission() {
		return submission;
	}

	public void setSubmission(Submission submission) {
		this.submission = submission;
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

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Marker getAuthor() {
		return author;
	}

	public void setAuthor(Marker author) {
		this.author = author;
	}
}
