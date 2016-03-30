package com.ic.ee.core.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.jdbc.api.EnrollmentDAO;
import com.ic.ee.core.jdbc.rowmapper.EnrollmentRowMapper;
import com.ic.ee.domain.common.relationship.Enrollment;

public class JdbcEnrollmentDAO extends AbstractJdbcBaseDAO implements EnrollmentDAO {

	public JdbcEnrollmentDAO(DataSource dataSource) throws IOException {
		super(dataSource, "getEnrollmentsFromUsername.sql", "getEnrollmentsFromIds.sql", "addEnrollment.sql");
	}

	@Override
	public List<Enrollment> getEnrollments(String username) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("username", username);
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, new EnrollmentRowMapper());
	}

	@Override
	public List<Enrollment> getEnrollments(List<Integer> enrollmentIds) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("enrollmentIds", enrollmentIds);
		return getJdbcTemplate().query(getSqlStatements().get(1), paramSource, new EnrollmentRowMapper());
	}

	@Override
	public Integer addEnrollment(Enrollment enrollment) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("username", enrollment.getStudent().getUserName());
		paramSource.addValue("courseId", enrollment.getCourse().getCourseId());
		paramSource.addValue("enrollmentLevel", enrollment.getEnrollmentLevel().toString());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(getSqlStatements().get(2), paramSource, keyHolder);
		return keyHolder.getKey().intValue();
	}

}
