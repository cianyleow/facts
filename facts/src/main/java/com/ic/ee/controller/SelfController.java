package com.ic.ee.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.relationship.Enrollment;
import com.ic.ee.domain.course.Course;
import com.ic.ee.service.api.CourseService;
import com.ic.ee.service.api.EnrollmentService;
import com.ic.ee.service.api.FeedbackService;

@RestController
public class SelfController {

	@Autowired
	private EnrollmentService enrollmentService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private FeedbackService feedbackService;

	@RequestMapping(path = "/self/enrolledCourses", method = RequestMethod.GET)
	public List<Course> getEnrolledCourses(Principal user) {
		return courseService.getEnrolledCourses(enrollmentService.getEnrollments(user.getName()));
	}

	@RequestMapping(path = "/self/enrollments", method = RequestMethod.GET)
	public List<Enrollment> getEnrollments(Principal user) {
		return enrollmentService.decorateCourses(enrollmentService.getEnrollments(user.getName()));
	}

	@RequestMapping(path = "/self/markedCourses", method = RequestMethod.GET)
	public List<Course> getMarkedCourses(Principal user) {
		return courseService.getMarkedCourses(user.getName());
	}

	@RequestMapping(path = "/self/ownedCourses", method = RequestMethod.GET)
	public List<Course> getOwnedCourses(Principal user) {
		return courseService.getOwnedCourses(user.getName());
	}

	@RequestMapping(path = "/self/marking", method = RequestMethod.GET)
	public List<Feedback> getMarking(Principal user) {
		return feedbackService.getFeedback(user.getName());
	}
}
