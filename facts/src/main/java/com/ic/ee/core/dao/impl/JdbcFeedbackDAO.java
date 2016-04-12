package com.ic.ee.core.dao.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.api.FeedbackDAO;
import com.ic.ee.core.dao.rowmapper.FeedbackRowMapper;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.feedback.comment.CommentStatus;
import com.ic.ee.domain.common.feedback.mark.MarkStatus;

public class JdbcFeedbackDAO extends AbstractJdbcBaseDAO implements FeedbackDAO {

	public JdbcFeedbackDAO(DataSource dataSource) throws IOException {
		super(dataSource, "createFeedback.sql", "getFeedbackByIds.sql");
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
	public List<Feedback> getFeedback(List<Integer> feedbackIds) {
		SqlParameterSource paramSource = new MapSqlParameterSource("feedbackIds", feedbackIds);
		return getJdbcTemplate().query(getSqlStatements().get(1), paramSource, new FeedbackRowMapper());
	}

}
