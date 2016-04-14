package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.MarkDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.MarkRowMapper;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.feedback.mark.Mark;

public class JdbcMarkDAO extends AbstractJdbcBaseDAO<Mark, Integer> implements MarkDAO {

	public JdbcMarkDAO(DataSource dataSource) throws IOException {
		super(dataSource, new MarkRowMapper(), Mark.class, "severalMarkForFeedback.sql");
	}

	@Override
	public List<Mark> getMarks(Feedback feedback) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("feedbackId", feedback.getFeedbackId());
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, getRowMapper());
	}

	@Override
	public MapSqlParameterSource getSqlParameterSource(Mark object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("markId", object.getMarkId());
		paramSource.addValue("markComponentId", object.getMarkComponent().getMarkComponentId());
		paramSource.addValue("feedbackId", object.getFeedback().getFeedbackId());
		paramSource.addValue("mark", object.getMark());
		paramSource.addValue("marker", object.getMarker().getUserName());
		return paramSource;
	}

	@Override
	public Integer extractKey(KeyHolder keyHolder) {
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer getKey(Mark object) {
		return object.getMarkId();
	}


}
