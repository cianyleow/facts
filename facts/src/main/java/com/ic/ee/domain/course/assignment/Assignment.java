package com.ic.ee.domain.course.assignment;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.common.file.FileRequirement;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.assignment.submission.Submission;

public class Assignment {

	private Integer assignmentId;

	private String name;
	private String description;
	private Date creationTime;

	private Timestamp dueTime;

	private Timestamp openTime;

	private List<FileRequirement> requiredFiles;

	private List<File> suppliedFiles;

	private List<Submission> submissions;

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
		if(submissions == null) {
			this.submissions = new ArrayList<Submission>();
		} else {
			this.submissions = submissions;
			for(Submission submission : submissions) {
				submission.setAssignment(this);
			}
		}
	}

	@JsonIgnore
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@JsonIgnore
	public List<FileRequirement> getRequiredFiles() {
		return requiredFiles;
	}

	@JsonProperty
	public void setRequiredFiles(List<FileRequirement> requiredFiles) {
		if(requiredFiles == null) {
			this.requiredFiles = new ArrayList<FileRequirement>();
		} else {
			this.requiredFiles = requiredFiles;
			for(FileRequirement requiredFile : requiredFiles) {
				requiredFile.setAssignment(this);
			}
		}
	}

	@JsonIgnore
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