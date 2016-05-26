package com.ic.ee.service.api;

import java.util.List;

import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.announcement.Announcement;

public interface CourseService {

	public Course getLiteCourse(Integer courseId);

	public Course getCourse(Integer courseId);

	public Course updateCourse(Course course);

	// Always returns lite version
	public List<Course> getCourses();

	// Get enrolled courses
	public List<Course> getEnrolledCourses(String username);

	// Get owned courses
	public List<Course> getOwnedCourses(String username);

	// Get marked courses
	public List<Course> getMarkedCourses(String username);

	public Announcement createAnnouncement(Integer courseId, Announcement announcement, String username);

	public void deleteAnnouncement(Integer announcementId);
}
