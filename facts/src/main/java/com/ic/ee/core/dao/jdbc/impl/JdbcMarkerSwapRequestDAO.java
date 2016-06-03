package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.MarkerSwapRequestDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.MarkerSwapRequestRowMapper;
import com.ic.ee.domain.user.marker.swap.MarkerSwapRequest;

public class JdbcMarkerSwapRequestDAO extends AbstractJdbcBaseDAO<MarkerSwapRequest, Integer>
		implements MarkerSwapRequestDAO {

	public JdbcMarkerSwapRequestDAO(DataSource dataSource) throws IOException {
		super(dataSource, new MarkerSwapRequestRowMapper(), MarkerSwapRequest.class);
	}

	@Override
	public MapSqlParameterSource getNewSqlParameterSource(MarkerSwapRequest object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("username", object.getNewMarker().getUserName());
		paramSource.addValue("feedbackId", object.getFeedback().getFeedbackId());
		paramSource.addValue("status", object.getStatus().toString());
		return paramSource;
	}

	@Override
	public MapSqlParameterSource getUpdateSqlParameterSource(MarkerSwapRequest updateObject, MarkerSwapRequest existingObject) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("status", updateObject.getStatus() == null ? existingObject.getStatus().toString() : updateObject.getStatus().toString());
		return paramSource;
	}

	@Override
	public Integer extractId(KeyHolder keyHolder) {
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer getId(MarkerSwapRequest object) {
		return object.getMarkerSwapRequestId();
	}
}
