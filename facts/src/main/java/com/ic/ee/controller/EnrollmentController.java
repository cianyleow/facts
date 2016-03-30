package com.ic.ee.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.domain.common.relationship.Enrollment;

@RestController
public class EnrollmentController {

	@RequestMapping("/enrollments/me")
	public List<Enrollment> getEnrollments(Principal user) {
		return null;
	}

	@RequestMapping("/enrollments/{username}")
	public List<Enrollment> getEnrollments(@PathVariable("username") String username) {
		return null;
	}

	@RequestMapping(path = "/enrollments/{enrollmentId}/details", method = RequestMethod.GET)
	public Enrollment getEnrollment(@PathVariable("enrollmentId") Integer enrollmentId) {
		return null;
	}

	@RequestMapping(path = "/enrollments/{enrollmentId}/details", method = RequestMethod.POST)
	public Integer addEnrollment(@RequestBody Enrollment enrollment) {
		return 0;
	}

	@RequestMapping(path = "/enrollments/{enrollmentId}/details", method = RequestMethod.PUT)
	public void updateEnrollment(@PathVariable("enrollmentId") Integer enrollmentId) {

	}

	@RequestMapping(path = "/enrollments/{enrollmentId}/details", method = RequestMethod.DELETE)
	public void deleteEnrollment(@PathVariable("enrollmentId") Integer enrollmentId) {

	}
}
