package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.course.assignment.submission.Submission;

public interface SubmissionDAO extends BaseDAO<Submission, Integer> {

	public void createSubmissionFile(Integer submissionId, Integer fileId);

	public List<Submission> getSubmissions(Assignment assignment);

	public List<Submission> getSubmissions(Assignment assignment, String username);

}
