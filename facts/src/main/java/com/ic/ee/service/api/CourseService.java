package com.ic.ee.service.api;

import java.util.List;

import com.ic.ee.domain.course.Course;

public interface CourseService {

	public Course getLiteCourse(Integer courseId);

	public Course getCourse(Integer courseId);

	// Always returns lite version
	public List<Course> getCourses();

	// Always returns lite version
	public List<Course> getCourses(String username);
}
