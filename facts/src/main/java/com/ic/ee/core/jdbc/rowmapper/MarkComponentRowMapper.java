package com.ic.ee.core.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.common.feedback.mark.MarkComponent;

public class MarkComponentRowMapper implements RowMapper<MarkComponent> {

	@Override
	public MarkComponent mapRow(ResultSet rs, int rowNum) throws SQLException {
		MarkComponent mc = new MarkComponent();
		mc.setMarkComponentId(rs.getInt("markComponentId"));
		mc.setMaxMark(rs.getInt("maxMark"));
		mc.setName(rs.getString("name"));
		mc.setDescription(rs.getString("description"));
		return mc;
	}

}
