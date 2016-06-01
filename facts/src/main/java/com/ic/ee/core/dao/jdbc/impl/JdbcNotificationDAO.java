package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.NotificationDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.NotificationRowMapper;
import com.ic.ee.domain.common.notification.Notification;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.User;

public class JdbcNotificationDAO extends AbstractJdbcBaseDAO<Notification, Integer> implements NotificationDAO {

	public JdbcNotificationDAO(DataSource dataSource) throws IOException {
		super(dataSource, new NotificationRowMapper(), Notification.class, "severalNotificationForRecipient.sql", "createNotificationForCourse.sql", "updateNotificationSeenForUser.sql", "deleteNotificationForUser.sql");
	}

	@Override
	public List<Notification> getNotifications(User user) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("username", user.getUserName());
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, getRowMapper());
	}

	@Override
	public void link(Notification notification, Course course) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("notificationId", notification.getNotificationId());
		paramSource.addValue("courseId", course.getCourseId());
		getJdbcTemplate().update(getSqlStatements().get(1), paramSource);
	}

	@Override
	public Notification markSeen(Integer notificationId, String username) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("notificationId", notificationId);
		paramSource.addValue("username", username);
		getJdbcTemplate().update(getSqlStatements().get(2), paramSource);
		return one(notificationId);
	}

	@Override
	public void deleteNotificationForUser(Integer notificationId, String username) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("notificationId", notificationId);
		paramSource.addValue("username", username);
		getJdbcTemplate().update(getSqlStatements().get(3), paramSource);
	}

	@Override
	public MapSqlParameterSource getNewSqlParameterSource(Notification object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("content", object.getContent());
		paramSource.addValue("link", object.getLink());
		paramSource.addValue("title", object.getTitle());
		return paramSource;
	}

	@Override
	public MapSqlParameterSource getUpdateSqlParameterSource(Notification updateObject, Notification existingObject) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		return paramSource;
	}

	@Override
	public Integer extractId(KeyHolder keyHolder) {
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer getId(Notification object) {
		return object.getNotificationId();
	}
}