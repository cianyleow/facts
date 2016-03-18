package com.ic.ee.core.jdbc.api;

import java.util.List;

import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.CourseDetails;

public interface CourseDAO {

	public Integer saveCourse(Course course);

	public Integer updateCourse(Course course);

	public List<Course> getCourses(List<Integer> courseIds);

	public List<CourseDetails> getCourseDetails(List<Integer> courseIds);
}
