package com.ic.ee.core.dao.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.common.feedback.mark.MarkComponent;
import com.ic.ee.domain.course.assignment.Assignment;

public class MarkComponentRowMapper implements RowMapper<MarkComponent> {

	@Override
	public MarkComponent mapRow(ResultSet rs, int rowNum) throws SQLException {
		MarkComponent mc = new MarkComponent(rs.getInt("markComponentId"));
		mc.setAssignment(new Assignment(rs.getInt("assignmentId")));
		mc.setMaxMark(rs.getInt("maxMark"));
		mc.setName(rs.getString("name"));
		mc.setDescription(rs.getString("description"));
		return mc;
	}

}
