package com.ic.ee.domain.course.assignment.submission;

import java.util.Date;
import java.util.Set;

import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.user.group.Group;
import com.ic.ee.domain.user.student.Student;

public class Submission {

	private Integer submissionId;

	private Assignment parentAssignment;

	private Student submitter;
	private Group group;

	private SubmissionStatus submissionStatus;

	private Date creationTime;

	private String comment;
	private Set<File> submittedFiles;

	private Feedback feedback;

	public Integer getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(Integer submissionId) {
		this.submissionId = submissionId;
	}

	public Assignment getParentAssignment() {
		return parentAssignment;
	}

	public void setParentAssignment(Assignment parentAssignment) {
		this.parentAssignment = parentAssignment;
	}

	public Student getSubmitter() {
		return submitter;
	}

	public void setSubmitter(Student submitter) {
		this.submitter = submitter;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
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

	public Set<File> getSubmittedFiles() {
		return submittedFiles;
	}

	public void setSubmittedFiles(Set<File> submittedFiles) {
		this.submittedFiles = submittedFiles;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
}