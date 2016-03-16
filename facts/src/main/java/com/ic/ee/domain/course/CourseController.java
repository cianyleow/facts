package com.ic.ee.domain.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.core.service.api.CourseService;

@RestController(value = "/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public List<CourseDetails> getCourses() {
		return courseService.getAllCourseDetails();
	}

	@RequestMapping(path = "/{courseId}", method = RequestMethod.GET)
	public Course getCourse(@PathVariable("courseId") Integer courseId) {
		return courseService.getCourse(courseId);
	}

	@RequestMapping(path = "/{courseId}/details", method = RequestMethod.GET)
	public CourseDetails getCourseDetails(@PathVariable("courseId") Integer courseId) {
		return courseService.getCourseDetails(courseId);
	}
}
