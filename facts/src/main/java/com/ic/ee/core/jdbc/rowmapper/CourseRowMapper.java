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
		course.setCourseId(rs.getInt("course.courseId"));
		course.setDescription(rs.getString("course.description"));
		course.setName(rs.getString("course.name"));
		course.setShortName(rs.getString("course.shortName"));
		AcademicPeriod ap = new AcademicPeriod();
		ap.setAcademicPeriodId(rs.getInt("academic_period.academicPeriodId"));
		ap.setEndTime(rs.getDate("academic_period.endTime"));
		ap.setStartTime(rs.getDate("academic_period.startTime"));
		ap.setName(rs.getString("academic_period.name"));
		ap.setShortName(rs.getString("academic_period.shortName"));
		course.setAcademicPeriod(ap);
		return course;
	}

}
