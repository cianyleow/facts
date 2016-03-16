package com.ic.ee.core.jdbc.impl;

import java.io.IOException;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.ic.ee.core.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.jdbc.api.CourseDAO;
import com.ic.ee.core.jdbc.rowmapper.CourseDetailsRowMapper;
import com.ic.ee.domain.common.AcademicPeriod;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.CourseDetails;

public class JdbcCourseDAO extends AbstractJdbcBaseDAO implements CourseDAO {
	Logger logger = Logger.getLogger(this.getClass());

	public JdbcCourseDAO(DataSource dataSource) throws IOException {
		super(dataSource, "getOneCourseDetails.sql");
	}

	@Override
	public Course saveCourse(Course newCourse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course getCourse(Integer courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseDetails getCourseDetails(Integer courseId) {
		SqlParameterSource paramSource = new MapSqlParameterSource("courseId", courseId);
		return getJdbcTemplate().queryForObject(getSqlStatements().get(0), paramSource, new CourseDetailsRowMapper());
	}

	@Override
	public Course getCurrentYearCourses(AcademicPeriod academicPeriod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<CourseDetails> getAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}

}
