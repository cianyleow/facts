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
		Enrollment enrollment = new Enrollment(rs.getInt("enrollmentId"));
		enrollment.setCourse(new Course(rs.getInt("courseId")));
		enrollment.setStudent(new Student(rs.getString("username")));
		enrollment.setUpdateTime(rs.getDate("updateTime"));
		enrollment.setEnrollmentLevel(EnrollmentLevel.valueOf(rs.getString("enrollmentLevel")));
		return enrollment;
	}

}
