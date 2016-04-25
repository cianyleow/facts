package com.ic.ee.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.domain.common.relationship.Enrollment;
import com.ic.ee.domain.course.Course;
import com.ic.ee.service.api.CourseService;

@RestController
public class SelfController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(path = "/self/enrollments", method = RequestMethod.GET)
	public List<Enrollment> getEnrolledCourses(Principal user) {
		return courseService.getEnrollments(user.getName());
	}

	@RequestMapping(path = "/self/marked", method = RequestMethod.GET)
	public List<Course> getMarkedCourses(Principal user) {
		return courseService.getMarkedCourses(user.getName());
	}

	@RequestMapping(path = "/self/owned", method = RequestMethod.GET)
	public List<Course> getOwnedCourses(Principal user) {
		return courseService.getOwnedCourses(user.getName());
	}
}
