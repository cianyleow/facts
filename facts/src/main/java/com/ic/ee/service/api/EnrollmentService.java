package com.ic.ee.service.api;

import java.util.List;

import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.relationship.Enrollment;

public interface EnrollmentService {

	public List<Enrollment> getEnrollments(String username);

	public Enrollment getEnrollment(Integer enrollmentId) throws NoResultsReturnedException, TooManyResultsReturnedException;

	public Integer addEnrollment(Enrollment enrollment);

	public void updateEnrollment(Integer enrollmentId, Enrollment enrollment);

	public void deleteEnrollment(Integer enrollmentId);
}
