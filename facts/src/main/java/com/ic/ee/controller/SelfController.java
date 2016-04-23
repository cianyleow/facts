package com.ic.ee.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.domain.course.Course;
import com.ic.ee.service.api.CourseService;

@RestController
public class SelfController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(path = "/self/courses", method = RequestMethod.GET)
	public List<Course> getEnrolledCourses(Principal user) {
		return courseService.getCourses(user.getName());
	}
}
