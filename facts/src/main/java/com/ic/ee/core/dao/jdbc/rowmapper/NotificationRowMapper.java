package com.ic.ee.core.dao.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.common.notification.Notification;

public class NotificationRowMapper implements RowMapper<Notification> {

	@Override
	public Notification mapRow(ResultSet rs, int rowNum) throws SQLException {
		Notification notification = new Notification(rs.getInt("notification.notificationId"));
		notification.setContent(rs.getString("content"));
		notification.setTitle(rs.getString("title"));
		notification.setLink(rs.getString("link"));
		notification.setSeen(rs.getBoolean("notification_for.seen"));
		notification.setCreationTime(rs.getTimestamp("creationTime"));
		return notification;
	}
}
