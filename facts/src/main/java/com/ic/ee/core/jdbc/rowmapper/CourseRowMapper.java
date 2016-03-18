package com.ic.ee.core.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.common.AcademicPeriod;
import com.ic.ee.domain.course.Course;

public class CourseRowMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course course = new Course();
		course.setCourseId(rs.getInt("courseId"));
		course.setDescription(rs.getString("description"));
		course.setName(rs.getString("name"));
		course.setShortName(rs.getString("shortName"));
		AcademicPeriod ap = new AcademicPeriod();
		ap.setAcademicPeriodId(rs.getInt("academicPeriodId"));
		course.setAcademicPeriod(ap);
		return course;
	}

}
