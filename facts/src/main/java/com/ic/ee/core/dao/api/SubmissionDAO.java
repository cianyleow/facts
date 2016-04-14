package com.ic.ee.core.dao.api;

import com.ic.ee.domain.course.assignment.submission.Submission;

public interface SubmissionDAO {

	public Submission getSubmission(Integer submissionId);

	public Integer createSubmission(Integer assignmentId, String username, Submission submission);

	public void createSubmissionFile(Integer submissionId, Integer fileId);

}
