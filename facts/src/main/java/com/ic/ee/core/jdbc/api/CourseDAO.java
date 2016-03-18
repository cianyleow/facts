package com.ic.ee.core.jdbc.api;

import java.util.List;

import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.CourseDetails;

public interface CourseDAO {

	public Integer saveCourse(Course newCourse);

	public Course updateCourse(Course course);

	public Course getCourse(Course course);

	public List<CourseDetails> getCourseDetails(List<Integer> courseIds);
}
