package com.ic.ee.core.dao.api;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.course.assignment.submission.Submission;

public interface SubmissionDAO extends BaseDAO<Submission, Integer> {

	public void createSubmissionFile(Integer submissionId, Integer fileId);

}
