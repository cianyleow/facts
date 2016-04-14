package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.FeedbackDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.FeedbackRowMapper;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.feedback.comment.CommentStatus;
import com.ic.ee.domain.common.feedback.mark.MarkStatus;

public class JdbcFeedbackDAO extends AbstractJdbcBaseDAO<Feedback, Integer> implements FeedbackDAO {

	public JdbcFeedbackDAO(DataSource dataSource) throws IOException {
		super(dataSource, new FeedbackRowMapper(), Feedback.class, "createFeedback.sql");
	}

	@Override
	public Integer createFeedback(Integer submissionId, String username) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("submissionId", submissionId);
		paramSource.addValue("commentStatus", CommentStatus.COMMENT_PENDING.toString());
		paramSource.addValue("markStatus", MarkStatus.MARKS_PENDING.toString());
		paramSource.addValue("marker", username);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(getSqlStatements().get(0), paramSource, keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public MapSqlParameterSource getSqlParameterSource(Feedback object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("submissionId", object.getSubmission().getSubmissionId());
		paramSource.addValue("commentStatus", CommentStatus.COMMENT_PENDING.toString());
		paramSource.addValue("markStatus", MarkStatus.MARKS_PENDING.toString());
		paramSource.addValue("marker", object.getMarker().getUserName());
		return paramSource;
	}

	@Override
	public Integer extractKey(KeyHolder keyHolder) {
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer getKey(Feedback object) {
		return object.getFeedbackId();
	}
}
