package com.ic.ee.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.relationship.Enrollment;
import com.ic.ee.domain.user.User;
import com.ic.ee.service.api.EnrollmentService;
import com.ic.ee.service.api.UserService;

@RestController
public class SelfController {

	@Autowired
	private UserService userService;

	@Autowired
	private EnrollmentService enrollmentService;

	@RequestMapping(path = "/self", method = RequestMethod.GET)
	public User getSelf(Principal user) throws NoResultsReturnedException, TooManyResultsReturnedException {
		return userService.getUser(user.getName());
	}

	@RequestMapping(path = "/self/enrollments", method = RequestMethod.GET)
	public List<Enrollment> getSelfEnrollments(Principal user) {
		return enrollmentService.getEnrollments(user.getName());
	}
}
