package com.ic.ee.service.api;

import java.util.List;

import com.ic.ee.domain.common.relationship.Enrollment;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.announcement.Announcement;

public interface CourseService {

	public Course getLiteCourse(Integer courseId);

	public Course getCourse(Integer courseId);

	// Always returns lite version
	public List<Course> getCourses();

	// Get owned courses
	public List<Course> getOwnedCourses(String username);

	// Get marked courses
	public List<Course> getMarkedCourses(String username);

	// Get enrollments
	public List<Enrollment> getEnrollments(String username);

	public Announcement createAnnouncement(Integer courseId, Announcement announcement);
}
