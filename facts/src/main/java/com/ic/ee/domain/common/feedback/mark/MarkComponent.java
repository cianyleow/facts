package com.ic.ee.domain.common.feedback.mark;

import com.ic.ee.domain.course.assignment.Assignment;

public class MarkComponent {

	private Integer markComponentId;

	private Assignment assignment;

	private Integer maxMark;
	private String name;
	private String description;

	public MarkComponent() {
		// TODO Auto-generated constructor stub
	}

	public MarkComponent(Integer markComponentId) {
		this.markComponentId = markComponentId;
	}

	public Integer getMarkComponentId() {
		return markComponentId;
	}

	public void setMarkComponentId(Integer markComponentId) {
		this.markComponentId = markComponentId;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public Integer getMaxMark() {
		return maxMark;
	}

	public void setMaxMark(Integer maxMark) {
		this.maxMark = maxMark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
