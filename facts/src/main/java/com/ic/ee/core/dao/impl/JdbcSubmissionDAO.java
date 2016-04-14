package com.ic.ee.core.dao.impl;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.api.SubmissionDAO;
import com.ic.ee.core.dao.rowmapper.SubmissionRowMapper;
import com.ic.ee.domain.course.assignment.submission.Submission;

public class JdbcSubmissionDAO extends AbstractJdbcBaseDAO<Submission, Integer> implements SubmissionDAO {

	public JdbcSubmissionDAO(DataSource dataSource) throws IOException {
		super(dataSource, new SubmissionRowMapper(), Submission.class, "createSubmission.sql", "createSubmissionFile.sql");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer createSubmission(Integer assignmentId, String username, Submission submission) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("assignmentId", assignmentId);
		paramSource.addValue("username", username);
		paramSource.addValue("submissionStatus", submission.getSubmissionStatus().toString());
		paramSource.addValue("comment", submission.getComment());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(getSqlStatements().get(0), paramSource, keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public Submission getSubmission(Integer submissionId) {
		return one(submissionId);
	}

	@Override
	public void createSubmissionFile(Integer submissionId, Integer fileId) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("submissionId", submissionId);
		paramSource.addValue("fileId", fileId);
		getJdbcTemplate().update(getSqlStatements().get(1), paramSource);
	}

}
