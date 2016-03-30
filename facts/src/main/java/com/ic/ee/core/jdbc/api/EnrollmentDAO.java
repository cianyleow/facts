package com.ic.ee.core.jdbc.api;

import java.util.List;

import com.ic.ee.domain.common.relationship.Enrollment;

public interface EnrollmentDAO {

	public List<Enrollment> getEnrollments(String username);

	public List<Enrollment> getEnrollments(List<Integer> enrollmentIds);

	public Integer addEnrollment(Enrollment enrollment);
}
