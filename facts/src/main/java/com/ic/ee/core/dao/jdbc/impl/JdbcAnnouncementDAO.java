package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.AnnouncementDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.AnnouncementRowMapper;
import com.ic.ee.domain.course.announcement.Announcement;

public class JdbcAnnouncementDAO extends AbstractJdbcBaseDAO<Announcement, Integer> implements AnnouncementDAO {

	public JdbcAnnouncementDAO(DataSource dataSource) throws IOException {
		super(dataSource, new AnnouncementRowMapper(), Announcement.class);
	}

	@Override
	public MapSqlParameterSource getSqlParameterSource(Announcement object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("courseId", object.getCourse().getCourseId());
		paramSource.addValue("content", object.getContent());
		paramSource.addValue("link", object.getLink());
		paramSource.addValue("username", object.getCourseOwner().getUserName());
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
