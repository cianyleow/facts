package com.ic.ee.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.domain.common.relationship.Enrollment;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.user.courseowner.CourseOwner;
import com.ic.ee.domain.user.marker.Marker;
import com.ic.ee.domain.user.student.Student;
import com.ic.ee.service.api.AssignmentService;
import com.ic.ee.service.api.CourseService;

@RestController
public class CourseController {

	private final static Logger logger = Logger.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;

	@Autowired
	private AssignmentService assignmentService;

	@RequestMapping(path = "/courses", method = RequestMethod.GET)
	public List<Course> getCourses() {
		return courseService.getCourses();
	}

	@RequestMapping(path = "/courses/{courseId}", method = RequestMethod.GET)
	public Course getCourse(@PathVariable("courseId") Integer courseId) {
		return courseService.getLiteCourse(courseId);
	}

	@RequestMapping(path = "/courses/{courseId}/enrollments", method = RequestMethod.GET)
	public List<Enrollment> getEnrollments(@PathVariable("courseId") Integer courseId) {
		return courseService.getCourse(courseId).getEnrollments();
	}

	@RequestMapping(path = "/courses/{courseId}/students", method = RequestMethod.GET)
	public List<Student> getStudents(@PathVariable("courseId") Integer courseId) {
		return courseService.getCourse(courseId).getStudents();
	}

	@RequestMapping(path = "/courses/{courseId}/markers", method = RequestMethod.GET)
	public List<Marker> getMarkers(@PathVariable("courseId") Integer courseId) {
		return courseService.getCourse(courseId).getMarkers();
	}

	@RequestMapping(path = "/courses/{courseId}/courseOwners", method = RequestMethod.GET)
	public List<CourseOwner> getCourseOwner(@PathVariable("courseId") Integer courseId) {
		return courseService.getCourse(courseId).getCourseOwners();
	}

	@RequestMapping(path = "/courses/{courseId}/assignments", method = RequestMethod.GET)
	public List<Assignment> getAssignments(@PathVariable("courseId") Integer courseId) {
		return courseService.getCourse(courseId).getAssignments();
	}

	@RequestMapping(path = "/courses/{courseId}/assignments", method = RequestMethod.POST)
	public Assignment createAssignment(@PathVariable("courseId") Integer courseId, @RequestParam("files") MultipartFile[] files, @RequestParam("assignment") String assignmentString, Principal user) throws JsonParseException, JsonMappingException, IOException, IncorrectFileNameFormatException, FileUploadException, HashingException, NoResultsReturnedException {
		Assignment assignment = new ObjectMapper().readValue(assignmentString, Assignment.class);
		return assignmentService.createAssignment(courseId, assignment, files, user.getName());
	}
}
