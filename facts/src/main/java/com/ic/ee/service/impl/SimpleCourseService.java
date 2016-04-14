
package com.ic.ee.service.impl;

import java.util.List;

import com.ic.ee.core.dao.api.AssignmentDAO;
import com.ic.ee.core.dao.api.CourseDAO;
import com.ic.ee.domain.course.Course;
import com.ic.ee.service.api.CourseService;

public class SimpleCourseService implements CourseService {

	private final CourseDAO courseDAO;

	private final AssignmentDAO assignmentDAO;

	public SimpleCourseService(CourseDAO courseDAO, AssignmentDAO assignmentDAO) {
		this.courseDAO = courseDAO;
		this.assignmentDAO = assignmentDAO;
	}

	@Override
	public Course getLiteCourse(Integer courseId) {
		return courseDAO.one(courseId);
	}

	@Override
	public Course getCourse(Integer courseId){
		Course course = courseDAO.one(courseId);
		decorateCourse(course);
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
		course.setAssignments(assignmentDAO.getAssignments(course));
		// Decorate markers

		// Decorate course owner

	}
}
