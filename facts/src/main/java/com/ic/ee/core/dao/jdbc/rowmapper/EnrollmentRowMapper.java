package com.ic.ee.core.dao.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.common.relationship.Enrollment;
import com.ic.ee.domain.common.relationship.EnrollmentLevel;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.student.Student;

public class EnrollmentRowMapper implements RowMapper<Enrollment> {

	@Override
	public Enrollment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Enrollment enrollment = new Enrollment(rs.getInt("enrollment.enrollmentId"));
		enrollment.setStudent(new Student(rs.getString("enrollment.username")));
		enrollment.setUpdateTime(rs.getTimestamp("enrollment.updateTime"));
		enrollment.setEnrollmentLevel(EnrollmentLevel.valueOf(rs.getString("enrollment.enrollmentLevel")));
		Course course = new Course(rs.getInt("enrollment.courseId"));
		enrollment.setCourse(course);
		return enrollment;
	}

}
