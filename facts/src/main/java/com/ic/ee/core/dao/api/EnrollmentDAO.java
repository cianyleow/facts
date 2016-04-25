package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.common.relationship.Enrollment;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.student.Student;

public interface EnrollmentDAO extends BaseDAO<Enrollment, Integer> {

	public List<Enrollment> getEnrollments(Student student);

	public List<Enrollment> getEnrollments(Course course);

	public Enrollment getEnrollment(Integer courseId, String username);
}
