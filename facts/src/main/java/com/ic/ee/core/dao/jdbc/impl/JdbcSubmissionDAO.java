package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.SubmissionDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.SubmissionRowMapper;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.course.assignment.submission.Submission;

public class JdbcSubmissionDAO extends AbstractJdbcBaseDAO<Submission, Integer> implements SubmissionDAO {

	public JdbcSubmissionDAO(DataSource dataSource) throws IOException {
		super(dataSource, new SubmissionRowMapper(), Submission.class, "createSubmissionFile.sql", "severalSubmissionForAssignment.sql", "severalSubmissionForAssignmentAndUsername.sql");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createSubmissionFile(Integer submissionId, Integer fileId) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("submissionId", submissionId);
		paramSource.addValue("fileId", fileId);
		getJdbcTemplate().update(getSqlStatements().get(0), paramSource);
	}

	@Override
	public List<Submission> getSubmissions(Assignment assignment) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("assignmentId", assignment.getAssignmentId());
		return getJdbcTemplate().query(getSqlStatements().get(1), paramSource, getRowMapper());
	}

	@Override
	public List<Submission> getSubmissions(Assignment assignment, String username) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("assignmentId", assignment.getAssignmentId());
		paramSource.addValue("username", username);
		return getJdbcTemplate().query(getSqlStatements().get(2), paramSource, getRowMapper());
	}

	@Override
	public MapSqlParameterSource getNewSqlParameterSource(Submission object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("assignmentId", object.getAssignment().getAssignmentId());
		paramSource.addValue("username", object.getSubmitter().getUserName());
		paramSource.addValue("submissionStatus", object.getSubmissionStatus().toString());
		paramSource.addValue("comment", object.getComment());
		return paramSource;
	}

	@Override
	public MapSqlParameterSource getUpdateSqlParameterSource(Submission updateObject, Submission existingObject) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("submissionStatus", updateObject.getSubmissionStatus() == null ? existingObject.getSubmissionStatus().toString() : updateObject.getSubmissionStatus().toString());
		paramSource.addValue("comment", updateObject.getComment() == null ? existingObject.getComment() : updateObject.getComment());
		return paramSource;
	}

	@Override
	public Integer extractId(KeyHolder keyHolder) {
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer getId(Submission object) {
		return object.getSubmissionId();
	}
}
