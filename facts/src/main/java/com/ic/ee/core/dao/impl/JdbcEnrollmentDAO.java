package com.ic.ee.core.dao.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.api.EnrollmentDAO;
import com.ic.ee.core.dao.rowmapper.EnrollmentRowMapper;
import com.ic.ee.domain.common.relationship.Enrollment;

public class JdbcEnrollmentDAO extends AbstractJdbcBaseDAO<Enrollment, Integer> implements EnrollmentDAO {

	public JdbcEnrollmentDAO(DataSource dataSource) throws IOException {
		super(dataSource, new EnrollmentRowMapper(), Enrollment.class, "getEnrollmentsFromUsername.sql", "getEnrollmentsFromIds.sql", "addEnrollment.sql");
	}

	@Override
	public Enrollment getEnrollment(Integer enrollmentId) {
		return one(enrollmentId);
	}

	@Override
	public List<Enrollment> getEnrollments(String username) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("username", username);
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, getRowMapper());
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
