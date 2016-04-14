package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.MarkerDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.MarkerRowMapper;
import com.ic.ee.domain.user.marker.Marker;

public class JdbcMarkerDAO extends AbstractJdbcBaseDAO<Marker, String> implements MarkerDAO {

	public JdbcMarkerDAO(DataSource dataSource) throws IOException {
		super(dataSource, new MarkerRowMapper(), Marker.class);
	}

	@Override
	public MapSqlParameterSource getSqlParameterSource(Marker object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("email", object.getEmail());
		paramSource.addValue("firstName", object.getFirstName());
		paramSource.addValue("lastName", object.getLastName());
		paramSource.addValue("title", object.getTitle());
		return paramSource;
	}

	@Override
	public String extractId(KeyHolder keyHolder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId(Marker object) {
		return object.getUserName();
	}
}
