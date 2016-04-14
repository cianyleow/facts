package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.domain.course.Course;

public interface CourseDAO {

	public Course getCourse(Integer courseId);

	public List<Course> getCourses();

	public List<Course> getCourses(String username);
}
