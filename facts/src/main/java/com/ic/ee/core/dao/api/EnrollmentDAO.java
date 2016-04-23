package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.common.relationship.Enrollment;
import com.ic.ee.domain.course.Course;

public interface EnrollmentDAO extends BaseDAO<Enrollment, Integer> {

	public List<Enrollment> getEnrollments(String username);

	public List<Enrollment> getEnrollments(Course course);

	public Enrollment getEnrollment(Integer courseId, String username);
}
