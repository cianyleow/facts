package com.ic.ee.domain.common.feedback.mark;

public class MarkComponent {

	private Integer markComponentId;
	private Integer maxMark;
	private String name;
	private String description;

	public Integer getMarkComponentId() {
		return markComponentId;
	}

	public void setMarkComponentId(Integer markComponentId) {
		this.markComponentId = markComponentId;
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
