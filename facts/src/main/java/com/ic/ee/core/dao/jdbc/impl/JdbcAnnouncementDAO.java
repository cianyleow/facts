package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.AnnouncementDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.AnnouncementRowMapper;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.announcement.Announcement;

public class JdbcAnnouncementDAO extends AbstractJdbcBaseDAO<Announcement, Integer> implements AnnouncementDAO {

	public JdbcAnnouncementDAO(DataSource dataSource) throws IOException {
		super(dataSource, new AnnouncementRowMapper(), Announcement.class, "severalAnnouncementForCourse.sql");
	}

	@Override
	public List<Announcement> getAnnouncements(Course course) {
		SqlParameterSource paramSource = new MapSqlParameterSource("courseId", course.getCourseId());
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, getRowMapper());
	}

	@Override
	public MapSqlParameterSource getNewSqlParameterSource(Announcement object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("courseId", object.getCourse().getCourseId());
		paramSource.addValue("content", object.getContent());
		paramSource.addValue("title", object.getTitle());
		paramSource.addValue("username", object.getCourseOwner().getUserName());
		return paramSource;
	}

	@Override
	public MapSqlParameterSource getUpdateSqlParameterSource(Announcement updateObject, Announcement existingObject) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("content", updateObject.getContent() == null ? existingObject.getContent() : updateObject.getContent());
		paramSource.addValue("title", updateObject.getTitle() == null ? existingObject.getTitle() : updateObject.getTitle());
		return paramSource;
	}

	@Override
	public Integer extractId(KeyHolder keyHolder) {
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer getId(Announcement object) {
		return object.getAnnouncementId();
	}

}
