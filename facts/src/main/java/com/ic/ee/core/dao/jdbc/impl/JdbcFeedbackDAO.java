package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.FeedbackDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.FeedbackRowMapper;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.user.marker.Marker;

public class JdbcFeedbackDAO extends AbstractJdbcBaseDAO<Feedback, Integer> implements FeedbackDAO {

	public JdbcFeedbackDAO(DataSource dataSource) throws IOException {
		super(dataSource, new FeedbackRowMapper(), Feedback.class, "oneFeedbackForSubmission.sql", "severalFeedbackForMarker.sql");
	}

	@Override
	public Feedback getFeedback(Submission submission) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("submissionId", submission.getSubmissionId());
		return getJdbcTemplate().queryForObject(getSqlStatements().get(0), paramSource, getRowMapper());
	}

	@Override
	public List<Feedback> getFeedback(Marker marker) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("username", marker.getUserName());
		return getJdbcTemplate().query(getSqlStatements().get(1), paramSource, getRowMapper());
	}

	@Override
	public MapSqlParameterSource getNewSqlParameterSource(Feedback object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("submissionId", object.getSubmission().getSubmissionId());
		paramSource.addValue("feedbackStatus", object.getFeedbackStatus().toString());
		paramSource.addValue("username", object.getMarker().getUserName());
		paramSource.addValue("mark", object.getMark());
		paramSource.addValue("dueTime", object.getDueTime());
		paramSource.addValue("commentReleased", object.getCommentReleased());
		paramSource.addValue("markReleased", object.getMarkReleased());
		return paramSource;
	}

	@Override
	public MapSqlParameterSource getUpdateSqlParameterSource(Feedback updateObject, Feedback existingObject) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("feedbackStatus", updateObject.getFeedbackStatus() == null ? existingObject.getFeedbackStatus().toString() : updateObject.getFeedbackStatus().toString());
		paramSource.addValue("username", updateObject.getMarker() == null ? existingObject.getMarker().getUserName() : updateObject.getMarker().getUserName());
		paramSource.addValue("mark", updateObject.getMark() == null ? existingObject.getMark() : updateObject.getMark());
		paramSource.addValue("dueTime", updateObject.getDueTime() == null ? existingObject.getDueTime() : updateObject.getDueTime());
		paramSource.addValue("commentReleased", updateObject.getCommentReleased() == null ? existingObject.getCommentReleased() : updateObject.getCommentReleased());
		paramSource.addValue("markReleased", updateObject.getMarkReleased() == null ? existingObject.getMarkReleased() : updateObject.getMarkReleased());
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
