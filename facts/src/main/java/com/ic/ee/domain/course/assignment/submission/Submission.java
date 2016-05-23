package com.ic.ee.domain.course.assignment.submission;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.ic.ee.domain.Views;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.user.student.Student;

public class Submission {

	@JsonView(Views.Public.class)
	private Integer submissionId;

	@JsonView(Views.Public.class)
	private SubmissionStatus submissionStatus;

	@JsonView(Views.Public.class)
	private Timestamp creationTime;

	@JsonView(Views.Student.class)
	private String comment;

	@JsonView(Views.Student.class)
	private List<File> submittedFiles;

	@JsonIgnore
	private Feedback feedback;

	@JsonView(Views.Marker.class)
	private Assignment assignment;

	@JsonIgnore
	private Student submitter;

	@JsonView(Views.Public.class)
	private Integer version;

	public Submission() {
		// TODO Auto-generated constructor stub
	}

	public Submission(Integer submissionId) {
		this.submissionId = submissionId;
	}

	@JsonIgnore
	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public Student getSubmitter() {
		return submitter;
	}

	public void setSubmitter(Student submitter) {
		this.submitter = submitter;
	}

	public Integer getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(Integer submissionId) {
		this.submissionId = submissionId;
	}

	public SubmissionStatus getSubmissionStatus() {
		return submissionStatus;
	}

	public void setSubmissionStatus(SubmissionStatus submissionStatus) {
		this.submissionStatus = submissionStatus;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<File> getSubmittedFiles() {
		return submittedFiles;
	}

	public void setSubmittedFiles(List<File> submittedFiles) {
		this.submittedFiles = submittedFiles;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}