package com.ic.ee.core.dao.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.user.courseowner.CourseOwner;

public class CourseOwnerRowMapper implements RowMapper<CourseOwner> {

	@Override
	public CourseOwner mapRow(ResultSet rs, int rowNum) throws SQLException {
		CourseOwner courseOwner = new CourseOwner(rs.getString("username"));
		courseOwner.setEmail(rs.getString("email"));
		courseOwner.setFirstName(rs.getString("firstName"));
		courseOwner.setLastName(rs.getString("lastName"));
		courseOwner.setTitle(rs.getString("title"));
		return courseOwner;
	}
}