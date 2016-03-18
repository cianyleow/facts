package com.ic.ee.core.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.course.assignment.AssignmentDetails;

public class AssignmentDetailsRowMapper implements RowMapper<AssignmentDetails> {

	@Override
	public AssignmentDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		AssignmentDetails details = new AssignmentDetails();
		details.setAssignmentId(rs.getInt("assignmentId"));
		details.setCreationTime(rs.getDate("creationTime"));
		details.setDescription(rs.getString("description"));
		details.setDueTime(rs.getDate("dueTime"));
		details.setName(rs.getString("name"));
		details.setOpenTime(rs.getDate("openTime"));
		return details;
	}

}
