package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.common.notification.Notification;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.User;

public interface NotificationDAO extends BaseDAO<Notification, Integer> {

	public List<Notification> getNotifications(User user);

	public void link(Notification notification, Course course);

	public Notification markSeen(Integer notificationId, String username);

	public void deleteNotificationForUser(Integer notificationId, String username);
}
