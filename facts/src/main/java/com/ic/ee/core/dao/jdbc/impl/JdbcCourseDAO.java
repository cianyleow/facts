package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.CourseDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.CourseRowMapper;
import com.ic.ee.domain.course.Course;

public class JdbcCourseDAO extends AbstractJdbcBaseDAO<Course, Integer> implements CourseDAO {
	Logger logger = Logger.getLogger(this.getClass());

	public JdbcCourseDAO(DataSource dataSource) throws IOException {
		super(dataSource, new CourseRowMapper(), Course.class, "getCourses.sql", "severalCourseByEnrolled.sql", "severalCourseByMarked.sql", "severalCourseByOwned.sql");
	}

	@Override
	public List<Course> getCourses() {
		return getJdbcTemplate().query(getSqlStatements().get(0), getRowMapper());
	}

	@Override
	public List<Course> getEnrolled(String username) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("username", username);
		return getJdbcTemplate().query(getSqlStatements().get(1), paramSource, getRowMapper());
	}

	@Override
	public List<Course> getMarked(String username) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("username", username);
		return getJdbcTemplate().query(getSqlStatements().get(2), paramSource, getRowMapper());
	}

	@Override
	public List<Course> getOwned(String username) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("username", username);
		return getJdbcTemplate().query(getSqlStatements().get(3), paramSource, getRowMapper());
	}

	@Override
	public MapSqlParameterSource getSqlParameterSource(Course object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("name", object.getName());
		paramSource.addValue("shortName", object.getShortName());
		paramSource.addValue("description", object.getDescription());
		paramSource.addValue("academicPeriodId", object.getAcademicPeriod().getAcademicPeriodId());
		return paramSource;
	}

	@Override
	public Integer extractId(KeyHolder keyHolder) {
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer getId(Course object) {
		return object.getCourseId();
	}
}
