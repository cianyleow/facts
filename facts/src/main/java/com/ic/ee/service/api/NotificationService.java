package com.ic.ee.service.api;

import java.util.List;

import com.ic.ee.domain.common.notification.Notification;
import com.ic.ee.domain.course.announcement.Announcement;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.user.User;

public interface NotificationService {

	public List<Notification> getNotifications(User user);

	public void createNotification(Announcement announcement);

	public void createNotification(Assignment assignment);
}
