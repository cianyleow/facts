package com.ic.ee.core.dao.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.course.assignment.Assignment;

public class AssignmentRowMapper implements RowMapper<Assignment> {

	@Override
	public Assignment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Assignment assignment = new Assignment();
		assignment.setAssignmentId(rs.getInt("assignmentId"));
		assignment.setName(rs.getString("name"));
		assignment.setDescription(rs.getString("description"));
		assignment.setCreationTime(rs.getDate("creationTime"));
		assignment.setDueTime(rs.getDate("dueTime"));
		assignment.setOpenTime(rs.getDate("openTime"));
		return assignment;
	}

}
