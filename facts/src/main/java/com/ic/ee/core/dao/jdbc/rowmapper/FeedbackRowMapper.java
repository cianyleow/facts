package com.ic.ee.core.dao.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.feedback.FeedbackStatus;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.user.marker.Marker;

public class FeedbackRowMapper implements RowMapper<Feedback> {

	@Override
	public Feedback mapRow(ResultSet rs, int rowNum) throws SQLException {
		Feedback feedback = new Feedback(rs.getInt("feedbackId"));
		feedback.setSubmission(new Submission(rs.getInt("submissionId")));
		feedback.setMarker(new Marker(rs.getString("username")));
		feedback.setFeedbackStatus(FeedbackStatus.valueOf(rs.getString("feedbackStatus")));
		feedback.setCommentReleased(rs.getBoolean("commentReleased"));
		feedback.setMark(rs.getDouble("mark"));
		feedback.setMarkReleased(rs.getBoolean("markReleased"));
		feedback.setDueTime(rs.getTimestamp("dueTime"));
		return feedback;
	}

}
