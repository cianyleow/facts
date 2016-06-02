package com.ic.ee.domain.common.feedback;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.ic.ee.domain.Views;
import com.ic.ee.domain.common.feedback.comment.Comment;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.user.marker.Marker;
import com.ic.ee.util.collection.CollectionUtil;
import com.ic.ee.util.collection.Includer;

public class Feedback {

	@JsonView(Views.Public.class)
	private Integer feedbackId;

	@JsonView(Views.Marker.class)
	private Submission submission;

	@JsonView(Views.Marker.class)
	private List<Comment> comments;

	@JsonView(Views.Student.class)
	private Boolean commentReleased;

	@JsonView(Views.Marker.class)
	private Double mark;

	@JsonView(Views.Student.class)
	private Boolean markReleased;

	@JsonView(Views.Marker.class)
	private FeedbackStatus feedbackStatus;

	@JsonView(Views.CourseOwner.class)
	private Marker marker;

	@JsonView(Views.Marker.class)
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

	public Boolean getCommentReleased() {
		return commentReleased;
	}

	public void setCommentReleased(Boolean commentReleased) {
		this.commentReleased = commentReleased;
	}

	public Marker getMarker() {
		return marker;
	}

	public void setMarker(Marker marker) {
		this.marker = marker;
	}

	public Double getMark() {
		return mark;
	}

	public void setMark(Double mark) {
		this.mark = mark;
	}

	public FeedbackStatus getFeedbackStatus() {
		return feedbackStatus;
	}

	public void setFeedbackStatus(FeedbackStatus feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}

	public Boolean getMarkReleased() {
		return markReleased;
	}

	public void setMarkReleased(Boolean markReleased) {
		this.markReleased = markReleased;
	}

	@JsonIgnore
	public List<Comment> getPublicComments() {
		if(!commentReleased || comments == null || comments.isEmpty()) {
			return Collections.emptyList();
		}
		return CollectionUtil.filterElements(comments, new Includer<Comment, Boolean>() {
			@Override
			public Boolean include(Comment element) {
				return !element.getSecret();
			}
		});
	}

	@JsonView(Views.Student.class)
	public String getGrade() {
		if(!markReleased || mark == null) {
			return null;
		} else if(mark > 70) {
			return "A*";
		} else if(mark < 70 || mark > 60) {
			return "B";
		} else if(mark < 60 || mark > 50) {
			return "C";
		} else if(mark < 50 || mark > 40) {
			return "D";
		} else if(mark < 40) {
			return "F";
		}
		return null;
	}

	public Timestamp getDueTime() {
		return dueTime;
	}

	public void setDueTime(Timestamp dueTime) {
		this.dueTime = dueTime;
	}
}
