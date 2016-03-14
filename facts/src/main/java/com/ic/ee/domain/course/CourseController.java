package com.ic.ee.domain.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.domain.course.dao.api.CourseDAO;

@RestController(value = "/courses")
public class CourseController {

	@Autowired
	private CourseDAO courseDAO;
}
