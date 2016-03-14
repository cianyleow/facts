package com.ic.ee.domain.common.feedback.mark;

import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.user.marker.Marker;

public class Mark {

	private Integer markId;

	private Submission submission;

	private MarkComponent markComponent;

	private Integer mark;

	private String grade;

	private Marker marker;

	public Integer getMarkId() {
		return markId;
	}

	public void setMarkId(Integer markId) {
		this.markId = markId;
	}

	public Submission getSubmission() {
		return submission;
	}

	public void setSubmission(Submission submission) {
		this.submission = submission;
	}

	public MarkComponent getMarkComponent() {
		return markComponent;
	}

	public void setMarkComponent(MarkComponent markComponent) {
		this.markComponent = markComponent;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Marker getMarker() {
		return marker;
	}

	public void setMarker(Marker marker) {
		this.marker = marker;
	}
}
