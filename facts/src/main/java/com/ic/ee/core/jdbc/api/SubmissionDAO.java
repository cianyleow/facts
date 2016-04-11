package com.ic.ee.core.jdbc.api;

import java.util.List;

import com.ic.ee.domain.course.assignment.submission.Submission;

public interface SubmissionDAO {

	public Integer createSubmission(Integer assignmentId, String username, Submission submission);

	public List<Submission> getSubmission(List<Integer> submissionIds);

	public void createSubmissionFile(Integer submissionId, Integer fileId);

}
