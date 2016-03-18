package com.ic.ee.core.service.api;

import java.util.List;

import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.CourseDetails;

public interface CourseService {

	// Creating

	public Integer createCourse(Course course);

	// Updating
	public Course updateCourse(Course course);

	// Deleting

	// Getting
	public List<CourseDetails> getAllCourseDetails();

	public CourseDetails getCourseDetails(Integer courseId);

	public Course getCourse(Integer courseId);

}
