package com.ic.ee.domain.course.assignment;

import java.util.Date;
import java.util.List;

import com.ic.ee.domain.common.feedback.mark.MarkComponent;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.common.file.FileRequirement;

public class Assignment {

	private Integer assignmentId;

	private String name;
	private String description;
	private Date creationTime;

	private Date dueTime;

	private Date openTime;

	private List<FileRequirement> requiredFiles;

	private List<MarkComponent> markComponents;

	private List<File> suppliedFiles;

	public List<FileRequirement> getRequiredFiles() {
		return requiredFiles;
	}

	public void setRequiredFiles(List<FileRequirement> requiredFiles) {
		this.requiredFiles = requiredFiles;
	}

	public List<MarkComponent> getMarkComponents() {
		return markComponents;
	}

	public void setMarkComponents(List<MarkComponent> markComponents) {
		this.markComponents = markComponents;
	}

	public List<File> getSuppliedFiles() {
		return suppliedFiles;
	}

	public void setSuppliedFiles(List<File> suppliedFiles) {
		this.suppliedFiles = suppliedFiles;
	}

	public Integer getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(Integer assignmentId) {
		this.assignmentId = assignmentId;
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

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getDueTime() {
		return dueTime;
	}

	public void setDueTime(Date dueTime) {
		this.dueTime = dueTime;
	}

	public Date getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
}