package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.common.relationship.Enrollment;

public interface EnrollmentDAO extends BaseDAO<Enrollment, Integer> {

	public List<Enrollment> getEnrollments(String username);

	public Integer addEnrollment(Enrollment enrollment);
}
