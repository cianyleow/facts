package com.ic.ee.core.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.feedback.comment.CommentStatus;
import com.ic.ee.domain.common.feedback.mark.MarkStatus;

public class FeedbackRowMapper implements RowMapper<Feedback> {

	@Override
	public Feedback mapRow(ResultSet rs, int rowNum) throws SQLException {
		Feedback feedback = new Feedback();
		feedback.setFeedbackId(rs.getInt("feedbackId"));
		feedback.setCommentStatus(CommentStatus.valueOf(rs.getString("commentStatus")));
		feedback.setMarkStatus(MarkStatus.valueOf(rs.getString("markStatus")));
		return feedback;
	}

}
