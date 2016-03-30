package com.ic.ee.core.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.jdbc.api.CourseDAO;
import com.ic.ee.core.jdbc.rowmapper.CourseRowMapper;
import com.ic.ee.domain.course.Course;

public class JdbcCourseDAO extends AbstractJdbcBaseDAO implements CourseDAO {
	Logger logger = Logger.getLogger(this.getClass());

	public JdbcCourseDAO(DataSource dataSource) throws IOException {
		super(dataSource, "saveCourse.sql", "updateCourse.sql", "getCoursesByCourseIds.sql");
	}

	@Override
	public Integer saveCourse(Course course) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("name", course.getName());
		paramSource.addValue("shortName", course.getShortName());
		paramSource.addValue("description", course.getDescription());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(getSqlStatements().get(0), paramSource, keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer updateCourse(Course course) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("courseId", course.getCourseId());
		paramSource.addValue("name", course.getName());
		paramSource.addValue("shortName", course.getShortName());
		paramSource.addValue("description", course.getDescription());
		return getJdbcTemplate().update(getSqlStatements().get(1), paramSource);
	}

	@Override
	public List<Course> getCourses(List<Integer> courseIds) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("courseIds", courseIds);
		return getJdbcTemplate().query(getSqlStatements().get(2), paramSource, new CourseRowMapper());
	}
}
