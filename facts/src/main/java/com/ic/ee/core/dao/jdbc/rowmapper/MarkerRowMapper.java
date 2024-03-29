package com.ic.ee.core.dao.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.user.marker.Marker;

public class MarkerRowMapper implements RowMapper<Marker> {

	@Override
	public Marker mapRow(ResultSet rs, int rowNum) throws SQLException {
		Marker marker = new Marker(rs.getString("username"));
		marker.setEmail(rs.getString("email"));
		marker.setFirstName(rs.getString("firstName"));
		marker.setLastName(rs.getString("lastName"));
		marker.setTitle(rs.getString("title"));
		return marker;
	}
}
