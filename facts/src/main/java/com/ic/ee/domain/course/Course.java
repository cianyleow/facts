package com.ic.ee.domain.course;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.user.User;

public class Course {

	private Integer courseId;

	private String name;
	private String shortName;
	private String description;

	private List<Assignment> assignments;

	private List<User> markers;

	private User courseOwner;

	@JsonIgnore
	public List<User> getMarkers() {
		return markers;
	}

	public void setMarkers(List<User> markers) {
		this.markers = markers;
	}

	@JsonIgnore
	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	@JsonIgnore
	public User getCourseOwner() {
		return courseOwner;
	}

	public void setCourseOwner(User courseOwner) {
		this.courseOwner = courseOwner;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
