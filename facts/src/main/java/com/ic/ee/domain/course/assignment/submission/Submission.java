package com.ic.ee.domain.course.assignment.submission;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.user.User;

public class Submission {

	private Integer submissionId;

	private SubmissionStatus submissionStatus;

	private Date creationTime;

	private String comment;
	private List<File> submittedFiles;

	private Feedback feedback;

	private Assignment assignment;

	private User submitter;

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

	public User getSubmitter() {
		return submitter;
	}

	public void setSubmitter(User submitter) {
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

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@JsonIgnore
	public List<File> getSubmittedFiles() {
		return submittedFiles;
	}

	public void setSubmittedFiles(List<File> submittedFiles) {
		this.submittedFiles = submittedFiles;
	}

	@JsonIgnore
	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
}