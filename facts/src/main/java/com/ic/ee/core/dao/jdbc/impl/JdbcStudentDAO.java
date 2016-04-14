package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.StudentDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.StudentRowMapper;
import com.ic.ee.domain.user.student.Student;

public class JdbcStudentDAO extends AbstractJdbcBaseDAO<Student, String> implements StudentDAO {

	public JdbcStudentDAO(DataSource dataSource) throws IOException {
		super(dataSource, new StudentRowMapper(), Student.class);
	}

	@Override
	public MapSqlParameterSource getSqlParameterSource(Student object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("email", object.getEmail());
		paramSource.addValue("firstName", object.getFirstName());
		paramSource.addValue("lastName", object.getLastName());
		paramSource.addValue("studentId", object.getStudentId());
		paramSource.addValue("yearOfStudy", object.getYearOfStudy());
		return paramSource;
	}

	@Override
	public String extractKey(KeyHolder keyHolder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKey(Student object) {
		return object.getUserName();
	}

}
