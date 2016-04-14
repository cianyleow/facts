package com.ic.ee.core.dao.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.feedback.mark.Mark;
import com.ic.ee.domain.common.feedback.mark.MarkComponent;
import com.ic.ee.domain.user.marker.Marker;

public class MarkRowMapper implements RowMapper<Mark> {

	@Override
	public Mark mapRow(ResultSet rs, int rowNum) throws SQLException {
		Mark mark = new Mark(rs.getInt("markId"));
		mark.setMarkComponent(new MarkComponent(rs.getInt("markComponentId")));
		mark.setFeedback(new Feedback(rs.getInt("feedbackId")));
		mark.setMark(rs.getInt("mark"));
		mark.setMarker(new Marker(rs.getString("marker")));
		return mark;
	}
}
