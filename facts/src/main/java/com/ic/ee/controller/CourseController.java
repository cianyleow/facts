package com.ic.ee.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.domain.Views;
import com.ic.ee.domain.common.relationship.Enrollment;
import com.ic.ee.domain.common.relationship.EnrollmentLevel;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.announcement.Announcement;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.user.marker.Marker;
import com.ic.ee.domain.user.student.Student;
import com.ic.ee.service.api.AssignmentService;
import com.ic.ee.service.api.CourseService;
import com.ic.ee.service.api.EnrollmentService;

@RestController
public class CourseController {

	private final static Logger logger = Logger.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;

	@Autowired
	private AssignmentService assignmentService;

	@Autowired
	private EnrollmentService enrollmentService;

	@JsonView(Views.Public.class)
	@RequestMapping(path = "/courses", method = RequestMethod.GET)
	public List<Course> getCourses() {
		return courseService.getCourses();
	}

	@JsonView(Views.Student.class)
	@RequestMapping(path = "/courses/{courseId}", method = RequestMethod.GET)
	public Course getCourse(@PathVariable("courseId") Integer courseId) {
		return courseService.getCourse(courseId);
	}

	@JsonView(Views.CourseOwner.class)
	@PreAuthorize("hasRole('ROLE_COURSE_OWNER')")
	@RequestMapping(path = "/courses/{courseId}/admin", method = RequestMethod.GET)
	public Course getAdminCourse(@PathVariable("courseId") Integer courseId) {
		return courseService.getCourse(courseId);
	}

	@JsonView(Views.Student.class)
	@RequestMapping(path = "/courses/{courseId}", method = RequestMethod.PUT)
	public Course updateCourse(@PathVariable("courseId") Integer courseId, @RequestBody Course course) {
		course.setCourseId(courseId);
		return courseService.updateCourse(course);
	}

	@JsonView(Views.CourseOwner.class)
	@PreAuthorize("hasRole('ROLE_COURSE_OWNER')")
	@RequestMapping(path = "/courses/{courseId}/enrollments", method = RequestMethod.GET)
	public List<Enrollment> getEnrollments(@PathVariable("courseId") Integer courseId) {
		return enrollmentService.decorateStudents(courseService.getCourse(courseId).getEnrollments());
	}

	@JsonView(Views.Public.class)
	@RequestMapping(path = "/courses/{courseId}/enrollments", method = RequestMethod.POST)
	public Enrollment enrollCourse(@PathVariable("courseId") Integer courseId, Principal user) {
		Enrollment enrollment = new Enrollment();
		enrollment.setCourse(new Course(courseId));
		enrollment.setStudent(new Student(user.getName()));
		enrollment.setEnrollmentLevel(EnrollmentLevel.NO_CREDIT);
		return enrollmentService.createEnrollment(enrollment);
	}

	@JsonView(Views.Student.class)
	@RequestMapping(path = "/courses/{courseId}/enrollment", method = RequestMethod.GET)
	public Enrollment getEnrollment(@PathVariable("courseId") Integer courseId, Principal user) {
		return enrollmentService.getEnrollment(courseId, user.getName());
	}

	@JsonView(Views.Student.class)
	@PreAuthorize("hasRole('ROLE_COURSE_OWNER')")
	@RequestMapping(path = "/courses/{courseId}/announcements", method = RequestMethod.POST)
	public Announcement createAnnouncement(@PathVariable("courseId") Integer courseId,
			@RequestBody Announcement announcement, Principal user) {
		return courseService.createAnnouncement(courseId, announcement, user.getName());
	}

	@JsonView(Views.Public.class)
	@PreAuthorize("hasRole('ROLE_COURSE_OWNER')")
	@RequestMapping(path = "/announcements/{announcementId}", method = RequestMethod.DELETE)
	public void deleteAnnouncement(@PathVariable("announcementId") Integer announcementId) {
		courseService.deleteAnnouncement(announcementId);
	}

	@JsonView(Views.Public.class)
	@RequestMapping(path = "/courses/{courseId}/students", method = RequestMethod.GET)
	public List<Student> getStudents(@PathVariable("courseId") Integer courseId) {
		return courseService.getCourse(courseId).getStudents();
	}

	@JsonView(Views.Public.class)
	@RequestMapping(path = "/courses/{courseId}/markers", method = RequestMethod.GET)
	public List<Marker> getMarkers(@PathVariable("courseId") Integer courseId) {
		return courseService.getCourse(courseId).getMarkers();
	}

	@JsonView(Views.Public.class)
	@PreAuthorize("hasRole('ROLE_COURSE_OWNER')")
	@RequestMapping(path = "/courses/{courseId}/assignments", method = RequestMethod.POST)
	public Assignment createAssignment(@PathVariable("courseId") Integer courseId,
			@RequestParam("files") MultipartFile[] files, @RequestParam("assignment") String assignmentString,
			Principal user)
					throws JsonParseException, JsonMappingException, IOException, IncorrectFileNameFormatException,
					FileUploadException, HashingException, NoResultsReturnedException {
		Assignment assignment = new ObjectMapper().readValue(assignmentString, Assignment.class);
		return assignmentService.createAssignment(courseId, assignment, files, user.getName());
	}
}
