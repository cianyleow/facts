package com.ic.ee.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.ic.ee.domain.Views;
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

	@JsonView(Views.Public.class)
	@RequestMapping(path = "/self/enrolledCourses", method = RequestMethod.GET)
	public List<Course> getEnrolledCourses(Principal user) {
		return courseService.getEnrolledCourses(enrollmentService.getEnrollments(user.getName()));
	}

	@JsonView(Views.Public.class)
	@RequestMapping(path = "/self/enrollments", method = RequestMethod.GET)
	public List<Enrollment> getEnrollments(Principal user) {
		return enrollmentService.decorateCourses(enrollmentService.getEnrollments(user.getName()));
	}

	@JsonView(Views.Public.class)
	@RequestMapping(path = "/self/markedCourses", method = RequestMethod.GET)
	public List<Course> getMarkedCourses(Principal user) {
		return courseService.getMarkedCourses(user.getName());
	}

	@JsonView(Views.Public.class)
	@RequestMapping(path = "/self/ownedCourses", method = RequestMethod.GET)
	public List<Course> getOwnedCourses(Principal user) {
		return courseService.getOwnedCourses(user.getName());
	}

	@JsonView(Views.Marker.class)
	@RequestMapping(path = "/self/marking", method = RequestMethod.GET)
	public List<Feedback> getMarking(Principal user) {
		return feedbackService.getFeedback(user.getName());
	}
}
