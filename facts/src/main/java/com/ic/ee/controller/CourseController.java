package com.ic.ee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.assignment.AssignmentDetails;
import com.ic.ee.service.api.AssignmentService;
import com.ic.ee.service.api.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private AssignmentService assignmentService;

	@RequestMapping(path = "/courses/{courseId}", method = RequestMethod.GET)
	@ResponseBody
	public Course getCourse(@PathVariable("courseId") Integer courseId) throws NoResultsReturnedException, TooManyResultsReturnedException {
		return courseService.getCourse(courseId);
	}

	@RequestMapping(path = "/courses/{courseId}/assignments", method = RequestMethod.GET)
	@ResponseBody
	public List<AssignmentDetails> getAssignmentDetailsForCourse(@PathVariable("courseId") Integer courseId) {
		return assignmentService.getAssignmentDetailsForCourse(courseId);
	}
}
