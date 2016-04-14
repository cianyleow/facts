package com.ic.ee.domain.course;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ic.ee.domain.common.relationship.Enrollment;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.user.User;
import com.ic.ee.domain.user.courseowner.CourseOwner;

public class Course {

	public Course() {
		// TODO Auto-generated constructor stub
	}

	private Integer courseId;

	private String name;
	private String shortName;
	private String description;

	private List<Assignment> assignments;

	private List<User> markers;

	private List<CourseOwner> courseOwners;

	private List<Enrollment> enrollments;

	public Course(Integer courseId) {
		this.courseId = courseId;
	}

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
	public List<CourseOwner> getCourseOwners() {
		return courseOwners;
	}

	public void setCourseOwners(List<CourseOwner> courseOwners) {
		this.courseOwners = courseOwners;
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

	@JsonIgnore
	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
}
