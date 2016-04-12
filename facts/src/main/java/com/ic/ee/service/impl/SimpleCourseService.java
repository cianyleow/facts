
package com.ic.ee.service.impl;

import java.util.Collections;
import java.util.List;

import com.ic.ee.core.dao.api.AssignmentDAO;
import com.ic.ee.core.dao.api.CourseDAO;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.service.api.CourseService;
import com.ic.ee.util.ElementExtractor;

public class SimpleCourseService implements CourseService {

	private final CourseDAO courseDAO;

	private final AssignmentDAO assignmentDAO;

	public SimpleCourseService(CourseDAO courseDAO, AssignmentDAO assignmentDAO) {
		this.courseDAO = courseDAO;
		this.assignmentDAO = assignmentDAO;
	}

	@Override
	public Course getCourse(Integer courseId, boolean lite) throws NoResultsReturnedException, TooManyResultsReturnedException {
		List<Course> courses = courseDAO.getCourses(Collections.singletonList(courseId));
		Course course = ElementExtractor.extractOne(courses);
		if(!lite) {
			decorateCourse(course);
		}
		return course;
	}

	@Override
	public List<Course> getCourses() {
		return courseDAO.getCourses();
	}

	@Override
	public List<Course> getCourses(String username) {
		return courseDAO.getCourses(username);
	}

	private void decorateCourse(Course course) {
		// Decorate assignments
		List<Assignment> assignments = assignmentDAO.getAssignments(course.getCourseId());
		course.setAssignments(assignments);
		// Decorate markers

		// Decorate course owner

	}
}
