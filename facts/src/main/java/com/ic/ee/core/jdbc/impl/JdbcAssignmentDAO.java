package com.ic.ee.core.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.ic.ee.core.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.jdbc.api.AssignmentDAO;
import com.ic.ee.core.jdbc.rowmapper.AssignmentDetailsRowMapper;
import com.ic.ee.domain.course.assignment.AssignmentDetails;

public class JdbcAssignmentDAO extends AbstractJdbcBaseDAO implements AssignmentDAO {

	public JdbcAssignmentDAO(DataSource dataSource) throws IOException {
		super(dataSource, "getAssignmentDetailsForCourse.sql", "getAssignmentDetails.sql");
	}

	@Override
	public List<AssignmentDetails> getAssignmentDetailsForCourse(Integer courseId) {
		SqlParameterSource paramSource = new MapSqlParameterSource("courseId", courseId);
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, new AssignmentDetailsRowMapper());
	}

	@Override
	public AssignmentDetails getAssignmentDetails(Integer assignmentId) {
		SqlParameterSource paramSource = new MapSqlParameterSource("assignmentId", assignmentId);
		return getJdbcTemplate().queryForObject(getSqlStatements().get(1), paramSource, new AssignmentDetailsRowMapper());
	}
}
