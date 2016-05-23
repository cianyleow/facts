package com.ic.ee.domain.course.assignment;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.ic.ee.domain.Views;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.common.file.FileRequirement;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.assignment.submission.Submission;

public class Assignment {

	@JsonView(Views.Public.class)
	private Integer assignmentId;

	@JsonView(Views.Public.class)
	private String name;

	@JsonView(Views.Public.class)
	private String description;

	@JsonView(Views.Public.class)
	private Date creationTime;

	@JsonView(Views.Public.class)
	private Timestamp dueTime;

	@JsonView(Views.Public.class)
	private Timestamp openTime;

	@JsonView(Views.Public.class)
	private List<FileRequirement> requiredFiles;

	@JsonView(Views.Public.class)
	private List<File> suppliedFiles;

	@JsonView(Views.CourseOwner.class)
	private List<Submission> submissions;

	@JsonView(Views.Public.class)
	private Course course;

	public Assignment() {
		// TODO Auto-generated constructor stub
	}

	public Assignment(Integer assignmentId) {
		this.assignmentId = assignmentId;
	}

	@JsonIgnore
	public List<Submission> getSubmissions() {
		return submissions;
	}

	public void setSubmissions(List<Submission> submissions) {
		this.submissions = submissions;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<FileRequirement> getRequiredFiles() {
		return requiredFiles;
	}

	public void setRequiredFiles(List<FileRequirement> requiredFiles) {
		this.requiredFiles = requiredFiles;
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

	public Timestamp getDueTime() {
		return dueTime;
	}

	public void setDueTime(Timestamp dueTime) {
		this.dueTime = dueTime;
	}

	public Timestamp getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Timestamp openTime) {
		this.openTime = openTime;
	}
}