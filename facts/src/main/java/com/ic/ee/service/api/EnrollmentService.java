package com.ic.ee.service.api;

import java.util.List;

import com.ic.ee.domain.common.relationship.Enrollment;

public interface EnrollmentService {

	public List<Enrollment> getEnrollments(String username);

	public Enrollment getEnrollment(Integer courseId, String username);

	public Enrollment getEnrollment(Integer enrollmentId);

	public Enrollment createEnrollment(Enrollment enrollment);

	public Enrollment updateEnrollment(Integer enrollmentId, Enrollment enrollment);

	public void deleteEnrollment(Integer enrollmentId);

	public List<Enrollment> decorateCourses(List<Enrollment> enrollments);

	public List<Enrollment> decorateStudents(List<Enrollment> enrollments);
}
