package com.ic.ee.core.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.course.CourseDetails;

public class CourseDetailsRowMapper implements RowMapper<CourseDetails> {

	@Override
	public CourseDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		CourseDetails details = new CourseDetails();
		details.setCourseId(rs.getInt("courseId"));
		details.setName(rs.getString("name"));
		details.setShortName(rs.getString("shortName"));
		details.setDescription(rs.getString("description"));
		return null;
	}



}
