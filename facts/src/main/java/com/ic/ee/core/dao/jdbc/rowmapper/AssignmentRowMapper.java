package com.ic.ee.core.dao.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.assignment.Assignment;

public class AssignmentRowMapper implements RowMapper<Assignment> {

	@Override
	public Assignment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Assignment assignment = new Assignment(rs.getInt("assignmentId"));
		assignment.setCourse(new Course(rs.getInt("courseId")));
		assignment.setName(rs.getString("name"));
		assignment.setDescription(rs.getString("description"));
		assignment.setCreationTime(rs.getTimestamp("creationTime"));
		assignment.setDueTime(rs.getTimestamp("dueTime"));
		assignment.setOpenTime(rs.getTimestamp("openTime"));
		return assignment;
	}

}
