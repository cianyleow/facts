package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.domain.common.relationship.Enrollment;

public interface EnrollmentDAO {

	public Enrollment getEnrollment(Integer enrollmentId);

	public List<Enrollment> getEnrollments(String username);

	public Integer addEnrollment(Enrollment enrollment);
}
