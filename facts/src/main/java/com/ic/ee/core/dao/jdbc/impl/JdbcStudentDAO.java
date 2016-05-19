package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.StudentDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.StudentRowMapper;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.student.Student;

public class JdbcStudentDAO extends AbstractJdbcBaseDAO<Student, String> implements StudentDAO {

	public JdbcStudentDAO(DataSource dataSource) throws IOException {
		super(dataSource, new StudentRowMapper(), Student.class, "severalStudentForCourse.sql");
	}

	@Override
	public List<Student> getStudents(Course course) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("courseId", course.getCourseId());
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, getRowMapper());
	}

	@Override
	public MapSqlParameterSource getNewSqlParameterSource(Student object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("username", object.getUserName());
		paramSource.addValue("studentId", object.getStudentId());
		paramSource.addValue("yearOfStudy", object.getYearOfStudy());
		return paramSource;
	}

	@Override
	public MapSqlParameterSource getUpdateSqlParameterSource(Student updateObject, Student existingObject) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("studentId", updateObject.getStudentId() == null ? existingObject.getStudentId() : updateObject.getStudentId());
		paramSource.addValue("yearOfStudy", updateObject.getYearOfStudy() == null ? existingObject.getYearOfStudy() : updateObject.getYearOfStudy());
		return paramSource;
	}

	@Override
	public String extractId(KeyHolder keyHolder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId(Student object) {
		return object.getUserName();
	}

}
