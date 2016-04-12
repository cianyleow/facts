package com.ic.ee.service.api;

import java.util.List;

import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.course.Course;

public interface CourseService {

	public Course getCourse(Integer courseId, boolean lite) throws NoResultsReturnedException, TooManyResultsReturnedException;

	// Always returns lite version
	public List<Course> getCourses();

	// Always returns lite version
	public List<Course> getCourses(String username);
}
