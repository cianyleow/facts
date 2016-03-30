package com.ic.ee.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.domain.common.relationship.Enrollment;
import com.ic.ee.service.api.EnrollmentService;

@RestController
public class EnrollmentController {

	@Autowired
	private EnrollmentService enrollmentService;

	@RequestMapping("/enrollments/me")
	public List<Enrollment> getEnrollments(Principal user) {
		return enrollmentService.getEnrollments(user.getName());
	}

	@RequestMapping("/enrollments/{username}")
	public List<Enrollment> getEnrollments(@PathVariable("username") String username) {
		return enrollmentService.getEnrollments(username);
	}

	@RequestMapping(path = "/enrollments/{enrollmentId}/details", method = RequestMethod.GET)
	public Enrollment getEnrollment(@PathVariable("enrollmentId") Integer enrollmentId) {
		return enrollmentService.getEnrollment(enrollmentId);
	}

	@RequestMapping(path = "/enrollments/{enrollmentId}/details", method = RequestMethod.POST)
	public Integer addEnrollment(@RequestBody Enrollment enrollment) {
		return enrollmentService.addEnrollment(enrollment);
	}

	@RequestMapping(path = "/enrollments/{enrollmentId}/details", method = RequestMethod.PUT)
	public void updateEnrollment(@PathVariable("enrollmentId") Integer enrollmentId, @RequestBody Enrollment enrollment) {
		enrollmentService.updateEnrollment(enrollmentId, enrollment);
	}

	@RequestMapping(path = "/enrollments/{enrollmentId}/details", method = RequestMethod.DELETE)
	public void deleteEnrollment(@PathVariable("enrollmentId") Integer enrollmentId) {
		enrollmentService.deleteEnrollment(enrollmentId);
	}
}
