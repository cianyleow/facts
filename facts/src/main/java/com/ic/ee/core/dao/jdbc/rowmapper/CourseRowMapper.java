package com.ic.ee.core.dao.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.course.Course;

public class CourseRowMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course course = new Course(rs.getInt("course.courseId"));
		course.setDescription(rs.getString("course.description"));
		course.setName(rs.getString("course.name"));
		course.setShortName(rs.getString("course.shortName"));
		return course;
	}

}
