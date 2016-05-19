package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.EnrollmentDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.EnrollmentRowMapper;
import com.ic.ee.domain.common.relationship.Enrollment;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.student.Student;

public class JdbcEnrollmentDAO extends AbstractJdbcBaseDAO<Enrollment, Integer> implements EnrollmentDAO {

	public JdbcEnrollmentDAO(DataSource dataSource) throws IOException {
		super(dataSource, new EnrollmentRowMapper(), Enrollment.class, "severalEnrollmentByUsername.sql", "severalEnrollmentForCourse.sql", "oneEnrollmentByCourseAndStudent.sql");
	}

	@Override
	public List<Enrollment> getEnrollments(Student student) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("username", student.getUserName());
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, getRowMapper());
	}

	@Override
	public List<Enrollment> getEnrollments(Course course) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("courseId", course.getCourseId());
		return getJdbcTemplate().query(getSqlStatements().get(1), paramSource, getRowMapper());
	}

	@Override
	public Enrollment getEnrollment(Integer courseId, String username) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("username", username);
		paramSource.addValue("courseId", courseId);
		return getJdbcTemplate().queryForObject(getSqlStatements().get(2), paramSource, getRowMapper());
	}

	@Override
	public MapSqlParameterSource getNewSqlParameterSource(Enrollment object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("username", object.getStudent().getUserName());
		paramSource.addValue("courseId", object.getCourse().getCourseId());
		paramSource.addValue("enrollmentLevel", object.getEnrollmentLevel().toString());
		return paramSource;
	}

	@Override
	public MapSqlParameterSource getUpdateSqlParameterSource(Enrollment updateObject, Enrollment existingObject) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("enrollmentLevel", updateObject.getEnrollmentLevel() == null ? existingObject.getEnrollmentLevel().toString() : updateObject.getEnrollmentLevel().toString());
		return paramSource;
	}

	@Override
	public Integer extractId(KeyHolder keyHolder) {
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer getId(Enrollment object) {
		return object.getEnrollmentId();
	}

}
