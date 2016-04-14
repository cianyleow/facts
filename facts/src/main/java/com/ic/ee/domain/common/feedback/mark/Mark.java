package com.ic.ee.domain.common.feedback.mark;

import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.user.marker.Marker;

public class Mark {

	private Integer markId;

	private Feedback feedback;

	private MarkComponent markComponent;

	private Integer mark;

	private String grade;

	private Marker marker;

	public Mark() {
		// TODO Auto-generated constructor stub
	}

	public Mark(Integer markId) {
		this.markId = markId;
	}

	public Integer getMarkId() {
		return markId;
	}

	public void setMarkId(Integer markId) {
		this.markId = markId;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
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
