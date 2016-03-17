package com.ic.ee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.core.service.api.CourseService;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.CourseDetails;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(path = "/courses", method = RequestMethod.GET)
	public List<CourseDetails> getCourses() {
		return courseService.getAllCourseDetails();
	}

	@RequestMapping(path = "/courses/{courseId}", method = RequestMethod.GET)
	public Course getCourse(@PathVariable("courseId") Integer courseId) {
		return courseService.getCourse(courseId);
	}

	@RequestMapping(path = "/courses/{courseId}/details", method = RequestMethod.GET)
	@ResponseBody
	public CourseDetails getCourseDetails(@PathVariable("courseId") Integer courseId) {
		return courseService.getCourseDetails(courseId);
	}
}
