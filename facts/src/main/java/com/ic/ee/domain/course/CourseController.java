package com.ic.ee.domain.course;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.core.jdbc.api.CourseDAO;

@RestController(value = "/courses")
public class CourseController {

	@Autowired
	private CourseDAO courseDAO;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public Set<CourseDetails> getCourses() {
		return courseDAO.getAllCourses();
	}

	@RequestMapping(path = "/{courseId}", method = RequestMethod.GET)
	public Course getCourse(@PathVariable("courseId") Integer courseId) {
		return courseDAO.getCourse(courseId);
	}

	@RequestMapping(path = "/{courseId}/details", method = RequestMethod.GET)
	public CourseDetails getCourseDetails(@PathVariable("courseId") Integer courseId) {
		return courseDAO.getCourseDetails(courseId);
	}
}
