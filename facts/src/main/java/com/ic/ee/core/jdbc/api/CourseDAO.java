package com.ic.ee.core.jdbc.api;

import java.util.List;

import com.ic.ee.domain.course.Course;

public interface CourseDAO {

	public List<Course> getCourses(List<Integer> courseIds);

	public List<Course> getCourses();

	public List<Course> getCourses(String username);
}
