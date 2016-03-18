package com.ic.ee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.core.service.api.AssignmentService;
import com.ic.ee.core.service.api.CourseService;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.CourseDetails;
import com.ic.ee.domain.course.assignment.AssignmentDetails;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private AssignmentService assignmentService;

	// POST (adding new element)
	@RequestMapping(path = "/courses", method = RequestMethod.POST)
	@ResponseBody
	public Integer addCourse(@RequestBody Course course) {
		return courseService.saveCourse(course);
	}

	// PUT (updating an element)

	// DELETE (deleting an element)

	// GET
	@RequestMapping(path = "/courses", method = RequestMethod.GET)
	@ResponseBody
	public List<CourseDetails> getCourses() {
		return courseService.getAllCourseDetails();
	}

	@RequestMapping(path = "/courses/{courseId}", method = RequestMethod.GET)
	@ResponseBody
	public Course getCourse(@PathVariable("courseId") Integer courseId) {
		return courseService.getCourse(courseId);
	}

	@RequestMapping(path = "/courses/{courseId}/details", method = RequestMethod.GET)
	@ResponseBody
	public CourseDetails getCourseDetails(@PathVariable("courseId") Integer courseId) {
		return courseService.getCourseDetails(courseId);
	}

	@RequestMapping(path = "/courses/{courseId}/assignments", method = RequestMethod.GET)
	@ResponseBody
	public List<AssignmentDetails> getAssignmentDetailsForCourse(@PathVariable("courseId") Integer courseId) {
		return assignmentService.getAssignmentDetailsForCourse(courseId);
	}
}
