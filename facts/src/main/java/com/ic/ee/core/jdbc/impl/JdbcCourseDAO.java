package com.ic.ee.core.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.ic.ee.core.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.jdbc.api.CourseDAO;
import com.ic.ee.core.jdbc.rowmapper.CourseDetailsRowMapper;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.CourseDetails;

public class JdbcCourseDAO extends AbstractJdbcBaseDAO implements CourseDAO {
	Logger logger = Logger.getLogger(this.getClass());

	public JdbcCourseDAO(DataSource dataSource) throws IOException {
		super(dataSource, "saveCourse.sql", "getOneCourseDetails.sql");
	}

	@Override
	public Integer saveCourse(Course course) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("name", course.getName());
		paramSource.addValue("shortName", course.getShortName());
		paramSource.addValue("academicPeriod", course.getAcademicPeriodId());
		if(course.getDescription() != null) {
			paramSource.addValue("description", course.getDescription());
		}
		return getJdbcTemplate().queryForObject(getSqlStatements().get(0), paramSource, Integer.class);
	}

	@Override
	public Course updateCourse(Course course) {
		return null;
	}

	@Override
	public Course getCourse(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseDetails> getCourseDetails(List<Integer> courseIds) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("courseIds", courseIds.toArray());
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, new CourseDetailsRowMapper());
	}


}
