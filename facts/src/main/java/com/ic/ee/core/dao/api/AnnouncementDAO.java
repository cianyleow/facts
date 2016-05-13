package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.announcement.Announcement;

public interface AnnouncementDAO extends BaseDAO<Announcement, Integer> {

	public List<Announcement> getAnnouncements(Course course);

}
