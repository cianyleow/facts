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

public class JdbcEnrollmentDAO extends AbstractJdbcBaseDAO<Enrollment, Integer> implements EnrollmentDAO {

	public JdbcEnrollmentDAO(DataSource dataSource) throws IOException {
		super(dataSource, new EnrollmentRowMapper(), Enrollment.class, "getEnrollmentsFromUsername.sql");
	}

	@Override
	public List<Enrollment> getEnrollments(String username) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("username", username);
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, getRowMapper());
	}

	@Override
	public MapSqlParameterSource getSqlParameterSource(Enrollment object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("username", object.getStudent().getUserName());
		paramSource.addValue("courseId", object.getCourse().getCourseId());
		paramSource.addValue("enrollmentLevel", object.getEnrollmentLevel().toString());
		return paramSource;
	}

	@Override
	public Integer extractKey(KeyHolder keyHolder) {
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer getKey(Enrollment object) {
		return object.getEnrollmentId();
	}

}
