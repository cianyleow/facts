package com.ic.ee.core.service.impl;

import java.util.List;

import com.ic.ee.core.jdbc.api.CourseDAO;
import com.ic.ee.core.service.api.CourseService;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.CourseDetails;

public class SimpleCourseService implements CourseService {

	private final CourseDAO courseDAO;

	public SimpleCourseService(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Override
	public List<CourseDetails> getAllCourseDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseDetails getCourseDetails(Integer courseId) {
		return courseDAO.getCourseDetails(courseId);
	}

	@Override
	public Course getCourse(Integer courseId) {
		// TODO Auto-generated method stub
		return null;
	}
}
