
package com.ic.ee.core.service.impl;

import java.util.ArrayList;
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
		List<CourseDetails> courseDetails = courseDAO.getCourseDetails(new ArrayList<Integer>(courseId));
		if(courseDetails == null) {
			// throw NoResultsReturnedError();
		} else if(courseDetails.isEmpty()) {
			// throw NoResultsReturnedError();
		} else if(courseDetails.size() > 1) {
			// throw TooManyResultsReturnedError();
		}
		return courseDetails.get(0);
	}

	@Override
	public Course getCourse(Integer courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer createCourse(Course course) {
		return courseDAO.saveCourse(course);
	}

	@Override
	public Course updateCourse(Course course) {
		return courseDAO.updateCourse(course);
	}
}
