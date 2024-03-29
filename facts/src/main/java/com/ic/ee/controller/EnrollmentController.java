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
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.student.Student;
import com.ic.ee.service.api.EnrollmentService;

@RestController
public class EnrollmentController {

	@Autowired
	private EnrollmentService enrollmentService;

	@RequestMapping("/enrollments/{username}")
	public List<Enrollment> getEnrollments(@PathVariable("username") String username) {
		return enrollmentService.getEnrollments(username);
	}

	@RequestMapping(path = "/enrollments/{enrollmentId}", method = RequestMethod.GET)
	public Enrollment getEnrollment(@PathVariable("enrollmentId") Integer enrollmentId) {
		return enrollmentService.getEnrollment(enrollmentId);
	}

	@RequestMapping(path = "/enrollments/{enrollmentId}", method = RequestMethod.PUT)
	public Enrollment updateEnrollment(@PathVariable("enrollmentId") Integer enrollmentId, @RequestBody Enrollment enrollment, Principal user) {
		enrollment.setStudent(new Student());
		enrollment.setCourse(new Course());
		return enrollmentService.updateEnrollment(enrollmentId, enrollment);
	}

	@RequestMapping(path = "/enrollments/{enrollmentId}", method = RequestMethod.DELETE)
	public void deleteEnrollment(@PathVariable("enrollmentId") Integer enrollmentId) {
		enrollmentService.deleteEnrollment(enrollmentId);
	}
}
