package com.ic.ee.service.api;

import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.course.assignment.submission.Submission;

public interface SubmissionService {

	public Submission createSubmission(Integer assignmentId, Submission submission, String username) throws NoResultsReturnedException, TooManyResultsReturnedException;

	public Submission getSubmission(Integer submissionId) throws NoResultsReturnedException, TooManyResultsReturnedException;


}
