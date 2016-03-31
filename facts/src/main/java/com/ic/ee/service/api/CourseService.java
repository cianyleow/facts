package com.ic.ee.service.api;

import java.util.List;

import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.course.Course;

public interface CourseService {

	public List<Course> getCourses();

	public Course getCourse(Integer courseId) throws NoResultsReturnedException, TooManyResultsReturnedException;

	public List<Course> getCourses(String username);
}
