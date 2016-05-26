package com.ic.ee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ic.ee.core.dao.api.NotificationDAO;
import com.ic.ee.domain.common.notification.Notification;
import com.ic.ee.domain.course.announcement.Announcement;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.user.User;
import com.ic.ee.service.api.NotificationService;

public class SimpleNotificationService implements NotificationService {

	private final NotificationDAO notificationDAO;

	public SimpleNotificationService(NotificationDAO notificationDAO) {
		this.notificationDAO = notificationDAO;
	}

	@Override
	public List<Notification> getNotifications(User user) {
		return notificationDAO.getNotifications(user);
	}

	@Transactional
	@Override
	public void createNotification(Announcement announcement) {
		Notification notification = new Notification();
		notification.setTitle("New Announcement");
		notification.setContent("A new announcement, concerning '" + announcement.getTitle() + "', was posted in this course at " + announcement.getCreationTime() + ".");
		notification.setLink("/courses/" + announcement.getCourse().getCourseId());
		Notification created = notificationDAO.create(notification);
		notificationDAO.link(created, announcement.getCourse());
	}

	@Transactional
	@Override
	public void createNotification(Assignment assignment) {
		Notification notification = new Notification();
		notification.setTitle("New Assignment Added");
		notification.setContent("Assignment: " + assignment.getName() + " has been created and is due at " + assignment.getDueTime().toString());
		notification.setLink("/courses/" + assignment.getCourse().getCourseId() + "/assignments/" + assignment.getAssignmentId());
		Notification created = notificationDAO.create(notification);
		notificationDAO.link(created, assignment.getCourse());
	}

}
