package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.CourseOwnerDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.CourseOwnerRowMapper;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.courseowner.CourseOwner;

public class JdbcCourseOwnerDAO extends AbstractJdbcBaseDAO<CourseOwner, String> implements CourseOwnerDAO {

	public JdbcCourseOwnerDAO(DataSource dataSource) throws IOException {
		super(dataSource, new CourseOwnerRowMapper(), CourseOwner.class, "severalCourseOwnerForCourse.sql");
	}

	@Override
	public List<CourseOwner> getCourseOwners(Course course) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("courseId", course.getCourseId());
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, getRowMapper());
	}

	@Override
	public MapSqlParameterSource getNewSqlParameterSource(CourseOwner object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("username", object.getUserName());
		paramSource.addValue("title", object.getTitle());
		return paramSource;
	}

	@Override
	public MapSqlParameterSource getUpdateSqlParameterSource(CourseOwner updateObject, CourseOwner existingObject) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("title", updateObject.getTitle() == null ? existingObject.getTitle() : updateObject.getTitle());
		return paramSource;
	}

	@Override
	public String extractId(KeyHolder keyHolder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId(CourseOwner object) {
		return object.getUserName();
	}
}
