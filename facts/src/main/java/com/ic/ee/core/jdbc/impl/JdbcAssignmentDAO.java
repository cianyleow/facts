package com.ic.ee.core.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.ic.ee.core.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.jdbc.api.AssignmentDAO;
import com.ic.ee.core.jdbc.rowmapper.AssignmentRowMapper;
import com.ic.ee.core.jdbc.rowmapper.FileRequirementRowMapper;
import com.ic.ee.domain.common.file.FileRequirement;
import com.ic.ee.domain.course.assignment.Assignment;

public class JdbcAssignmentDAO extends AbstractJdbcBaseDAO implements AssignmentDAO {

	public JdbcAssignmentDAO(DataSource dataSource) throws IOException {
		super(dataSource, "getAssignmentsByIds.sql", "getAssignmentsByCourse.sql", "getFileRequirementsByAssignment.sql");
	}

	@Override
	public List<Assignment> getAssignments(List<Integer> assignmentIds) {
		SqlParameterSource paramSource = new MapSqlParameterSource("assignmentIds", assignmentIds);
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, new AssignmentRowMapper());
	}

	@Override
	public List<Assignment> getAssignments(Integer courseId) {
		SqlParameterSource paramSource = new MapSqlParameterSource("courseId", courseId);
		return getJdbcTemplate().query(getSqlStatements().get(1), paramSource, new AssignmentRowMapper());
	}

	@Override
	public List<FileRequirement> getRequiredFiles(Integer assignmentId) {
		SqlParameterSource paramSource = new MapSqlParameterSource("assignmentId", assignmentId);
		return getJdbcTemplate().query(getSqlStatements().get(2), paramSource, new FileRequirementRowMapper());
	}


}
