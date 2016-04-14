package com.ic.ee.core.dao.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.user.student.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student(rs.getString("username"));
		student.setEmail(rs.getString("email"));
		student.setFirstName(rs.getString("firstName"));
		student.setLastName(rs.getString("lastName"));
		student.setStudentId(rs.getInt("studentId"));
		student.setYearOfStudy(rs.getInt("yearOfStudy"));
		return student;
	}

}
