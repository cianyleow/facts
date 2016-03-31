package com.ic.ee.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.User;
import com.ic.ee.service.api.CourseService;
import com.ic.ee.service.api.UserService;

@RestController
public class SelfController {

	@Autowired
	private UserService userService;

	@Autowired
	private CourseService courseService;

	@RequestMapping(path = "/self", method = RequestMethod.GET)
	public User getSelf(Principal user) throws NoResultsReturnedException, TooManyResultsReturnedException {
		return userService.getUser(user.getName());
	}

	@RequestMapping(path = "/self/courses", method = RequestMethod.GET)
	public List<Course> getEnrolledCourses(Principal user) {
		return courseService.getCourses(user.getName());
	}
}
