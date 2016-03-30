package com.ic.ee.core.jdbc.impl;

import java.io.IOException;

import javax.sql.DataSource;

import com.ic.ee.core.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.jdbc.api.AssignmentDAO;

public class JdbcAssignmentDAO extends AbstractJdbcBaseDAO implements AssignmentDAO {

	public JdbcAssignmentDAO(DataSource dataSource) throws IOException {
		super(dataSource, "getAssignmentDetailsForCourse.sql", "getAssignmentDetails.sql");
	}
//
//	@Override
//	public List<AssignmentDetails> getAssignmentDetailsForCourse(Integer courseId) {
//		SqlParameterSource paramSource = new MapSqlParameterSource("courseId", courseId);
//		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, new AssignmentDetailsRowMapper());
//	}
//
//	@Override
//	public AssignmentDetails getAssignmentDetails(Integer assignmentId) {
//		SqlParameterSource paramSource = new MapSqlParameterSource("assignmentId", assignmentId);
//		return getJdbcTemplate().queryForObject(getSqlStatements().get(1), paramSource, new AssignmentDetailsRowMapper());
//	}
}
