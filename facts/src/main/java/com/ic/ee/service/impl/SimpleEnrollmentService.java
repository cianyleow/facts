package com.ic.ee.service.impl;

import java.util.List;

import com.ic.ee.core.dao.api.EnrollmentDAO;
import com.ic.ee.domain.common.relationship.Enrollment;
import com.ic.ee.domain.user.student.Student;
import com.ic.ee.service.api.EnrollmentService;

public class SimpleEnrollmentService implements EnrollmentService {

	private final EnrollmentDAO enrollmentDAO;

	public SimpleEnrollmentService(EnrollmentDAO enrollmentDAO) {
		this.enrollmentDAO = enrollmentDAO;
	}

	@Override
	public Enrollment getEnrollment(Integer courseId, String username) {
		return enrollmentDAO.getEnrollment(courseId, username);
	}

	@Override
	public List<Enrollment> getEnrollments(String username) {
		return enrollmentDAO.getEnrollments(new Student(username));
	}

	@Override
	public Enrollment getEnrollment(Integer enrollmentId) {
		return enrollmentDAO.one(enrollmentId);
	}

	@Override
	public Enrollment createEnrollment(Enrollment enrollment) {
		return enrollmentDAO.create(enrollment);
	}

	@Override
	public Enrollment updateEnrollment(Integer enrollmentId, Enrollment enrollment) {
		enrollment.setEnrollmentId(enrollmentId);
		return enrollmentDAO.update(enrollment);
	}

	@Override
	public void deleteEnrollment(Integer enrollmentId) {
		enrollmentDAO.delete(enrollmentId);
	}

}
