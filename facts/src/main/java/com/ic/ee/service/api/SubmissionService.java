package com.ic.ee.service.api;

import java.util.List;

import com.ic.ee.domain.course.assignment.submission.Submission;

public interface SubmissionService {

	Submission getSubmission(Integer submissionId);

	List<Submission> getSubmissions(Integer assignmentId);


}
