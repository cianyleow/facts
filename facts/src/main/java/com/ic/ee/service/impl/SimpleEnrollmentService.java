package com.ic.ee.service.impl;

import java.util.Collections;
import java.util.List;

import com.ic.ee.core.jdbc.api.EnrollmentDAO;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.relationship.Enrollment;
import com.ic.ee.service.api.EnrollmentService;
import com.ic.ee.util.ElementExtractor;

public class SimpleEnrollmentService implements EnrollmentService {

	private final EnrollmentDAO enrollmentDAO;

	public SimpleEnrollmentService(EnrollmentDAO enrollmentDAO) {
		this.enrollmentDAO = enrollmentDAO;
	}

	@Override
	public List<Enrollment> getEnrollments(String username) {
		return enrollmentDAO.getEnrollments(username);
	}

	@Override
	public Enrollment getEnrollment(Integer enrollmentId) throws NoResultsReturnedException, TooManyResultsReturnedException {
		List<Enrollment> enrollments = enrollmentDAO.getEnrollments(Collections.singletonList(enrollmentId));
		return ElementExtractor.extractOne(enrollments);
	}

	@Override
	public Integer addEnrollment(Enrollment enrollment) {
		return enrollmentDAO.addEnrollment(enrollment);
	}

	@Override
	public void updateEnrollment(Integer enrollmentId, Enrollment enrollment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEnrollment(Integer enrollmentId) {
		// TODO Auto-generated method stub

	}

}
