package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.FeedbackDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.FeedbackRowMapper;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.course.assignment.submission.Submission;

public class JdbcFeedbackDAO extends AbstractJdbcBaseDAO<Feedback, Integer> implements FeedbackDAO {

	public JdbcFeedbackDAO(DataSource dataSource) throws IOException {
		super(dataSource, new FeedbackRowMapper(), Feedback.class, "oneFeedbackForSubmission.sql");
	}

	@Override
	public Feedback getFeedback(Submission submission) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("submissionId", submission.getSubmissionId());
		return getJdbcTemplate().queryForObject(getSqlStatements().get(0), paramSource, getRowMapper());
	}

	@Override
	public MapSqlParameterSource getSqlParameterSource(Feedback object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("submissionId", object.getSubmission().getSubmissionId());
		paramSource.addValue("commentStatus", object.getCommentStatus().toString());
		paramSource.addValue("marker", object.getMarker().getUserName());
		return paramSource;
	}

	@Override
	public Integer extractId(KeyHolder keyHolder) {
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer getId(Feedback object) {
		return object.getFeedbackId();
	}
}
