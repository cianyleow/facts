package com.ic.ee.core.dao.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.user.marker.Marker;
import com.ic.ee.domain.user.marker.swap.MarkerSwapRequest;
import com.ic.ee.domain.user.marker.swap.MarkerSwapRequestStatus;

public class MarkerSwapRequestRowMapper implements RowMapper<MarkerSwapRequest> {

	@Override
	public MarkerSwapRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
		MarkerSwapRequest markerSwapRequest = new MarkerSwapRequest(rs.getInt("markSwapRequestId"));
		markerSwapRequest.setFeedback(new Feedback(rs.getInt("feedbackId")));
		markerSwapRequest.setNewMarker(new Marker(rs.getString("username")));
		markerSwapRequest.setStatus(MarkerSwapRequestStatus.valueOf(rs.getString("status")));
		return markerSwapRequest;
	}

}
