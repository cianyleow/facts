package com.ic.ee.domain.course.assignment;

import java.util.Date;

import com.ic.ee.domain.course.Course;

public class Assignment {

	private Integer assignmentId;

	private Course course;

	private String name;
	private String description;
	private Date creationTime;
//	private Set<File> suppliedFiles;

	private Date dueTime;

	private Date openTime;
//
//	private GroupConstraint groupConstraint;
//
//	private Set<FileRequirement> requiredFiles;
//
//	private Set<MarkComponent> markComponents;

	public Integer getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(Integer assignmentId) {
		this.assignmentId = assignmentId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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