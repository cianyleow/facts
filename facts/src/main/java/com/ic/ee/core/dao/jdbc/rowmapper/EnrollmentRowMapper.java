package com.ic.ee.core.dao.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.common.relationship.Enrollment;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.student.Student;

public class EnrollmentRowMapper implements RowMapper<Enrollment> {

	@Override
	public Enrollment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Enrollment enrollment = new Enrollment();
		enrollment.setEnrollmentId(rs.getInt("enrollmentId"));
		Course course = new Course();
		course.setCourseId(rs.getInt("courseId"));
		enrollment.setCourse(course);
		Student student = new Student();
		student.setUserName(rs.getString("username"));
		enrollment.setStudent(student);
		enrollment.setUpdateTime(rs.getDate("updateTime"));
		return enrollment;
	}

}
