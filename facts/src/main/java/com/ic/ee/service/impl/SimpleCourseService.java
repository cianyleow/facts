
package com.ic.ee.service.impl;

import java.util.Collections;
import java.util.List;

import com.ic.ee.core.jdbc.api.CourseDAO;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.course.Course;
import com.ic.ee.service.api.CourseService;
import com.ic.ee.util.ElementExtractor;

public class SimpleCourseService implements CourseService {

	private final CourseDAO courseDAO;

	public SimpleCourseService(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Override
	public Course getCourse(Integer courseId) throws NoResultsReturnedException, TooManyResultsReturnedException {
		List<Course> courses = courseDAO.getCourses(Collections.singletonList(courseId));
		return ElementExtractor.extractOne(courses);
	}

	@Override
	public Integer saveCourse(Course course) {
		return courseDAO.saveCourse(course);
	}

	@Override
	public Boolean updateCourse(Course course) {
		return (courseDAO.updateCourse(course) == 1);
	}
}
