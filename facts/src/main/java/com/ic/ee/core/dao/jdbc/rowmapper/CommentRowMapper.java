package com.ic.ee.core.dao.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.feedback.comment.Comment;
import com.ic.ee.domain.user.marker.Marker;

public class CommentRowMapper implements RowMapper<Comment> {

	@Override
	public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Comment comment = new Comment(rs.getInt("commentId"));
		comment.setFeedback(new Feedback(rs.getInt("feedbackId")));
		comment.setComment(rs.getString("comment"));
		comment.setCreationTime(rs.getDate("creationTime"));
		comment.setSecret(rs.getBoolean("secret"));
		comment.setAuthor(new Marker(rs.getString("username")));
		return comment;
	}
}
