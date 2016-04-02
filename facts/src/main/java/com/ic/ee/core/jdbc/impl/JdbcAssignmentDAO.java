package com.ic.ee.core.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.jdbc.api.AssignmentDAO;
import com.ic.ee.core.jdbc.rowmapper.AssignmentRowMapper;
import com.ic.ee.core.jdbc.rowmapper.FileRequirementRowMapper;
import com.ic.ee.core.jdbc.rowmapper.MarkComponentRowMapper;
import com.ic.ee.domain.common.feedback.mark.MarkComponent;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.common.file.FileRequirement;
import com.ic.ee.domain.course.assignment.Assignment;

public class JdbcAssignmentDAO extends AbstractJdbcBaseDAO implements AssignmentDAO {

	public JdbcAssignmentDAO(DataSource dataSource) throws IOException {
		super(dataSource, "getAssignmentsByIds.sql", "getAssignmentsByCourse.sql",
				"getFileRequirementsByAssignment.sql", "getMarkComponentsByAssignment.sql",
				"getSuppliedFileIdsByAssignment.sql", "createAssignment.sql",
				"createAssignmentFile.sql");
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

	@Override
	public List<MarkComponent> getMarkComponents(Integer assignmentId) {
		SqlParameterSource paramSource = new MapSqlParameterSource("assignmentId", assignmentId);
		return getJdbcTemplate().query(getSqlStatements().get(3), paramSource, new MarkComponentRowMapper());
	}

	@Override
	public List<Integer> getSuppliedFileIds(Integer assignmentId) {
		SqlParameterSource paramSource = new MapSqlParameterSource("assignmentId", assignmentId);
		return getJdbcTemplate().queryForList(getSqlStatements().get(4), paramSource, Integer.class);
	}

	@Override
	public Integer createAssignment(Integer courseId, Assignment assignment) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("courseId", courseId);
		paramSource.addValue("name", assignment.getName());
		paramSource.addValue("description", assignment.getDescription());
		paramSource.addValue("dueTime", assignment.getDueTime());
		paramSource.addValue("openTime", assignment.getOpenTime());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(getSqlStatements().get(5), paramSource, keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public void createAssignmentFile(Integer assignmentId, File file) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("assignmentId", assignmentId);
		paramSource.addValue("fileId", file.getFileId());
		getJdbcTemplate().update(getSqlStatements().get(6), paramSource);
	}
}
