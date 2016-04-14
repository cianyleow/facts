package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.CommentDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.CommentRowMapper;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.feedback.comment.Comment;

public class JdbcCommentDAO extends AbstractJdbcBaseDAO<Comment, Integer> implements CommentDAO {

	public JdbcCommentDAO(DataSource dataSource) throws IOException {
		super(dataSource, new CommentRowMapper(), Comment.class, "severalCommentForFeedback.sql");
	}

	@Override
	public List<Comment> getComments(Feedback feedback) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("feedbackId", feedback.getFeedbackId());
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, getRowMapper());
	}

	@Override
	public MapSqlParameterSource getSqlParameterSource(Comment object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("feedbackId", object.getFeedback().getFeedbackId());
		paramSource.addValue("secret", object.getSecret());
		paramSource.addValue("comment", object.getComment());
		paramSource.addValue("author", object.getAuthor().getUserName());
		return paramSource;
	}

	@Override
	public Integer extractKey(KeyHolder keyHolder) {
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer getKey(Comment object) {
		return object.getCommentId();
	}

}
