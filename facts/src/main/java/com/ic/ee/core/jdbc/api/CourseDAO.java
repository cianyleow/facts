package com.ic.ee.core.jdbc.api;

import java.util.List;

import com.ic.ee.domain.course.Course;

public interface CourseDAO {

	public Integer saveCourse(Course course);

	public Integer updateCourse(Course course);

	public List<Course> getCourses(List<Integer> courseIds);
}
