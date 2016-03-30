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
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.user.courseowner.CourseOwner;
import com.ic.ee.domain.user.marker.Marker;
import com.ic.ee.domain.user.student.Student;
import com.ic.ee.service.api.AssignmentService;
import com.ic.ee.service.api.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private AssignmentService assignmentService;

	@RequestMapping(path = "/courses", method = RequestMethod.GET)
	@ResponseBody
	public List<Course> getCourses() {
		return null;
	}

	@RequestMapping(path = "/courses/{courseId}", method = RequestMethod.GET)
	@ResponseBody
	public Course getCourse(@PathVariable("courseId") Integer courseId) throws NoResultsReturnedException, TooManyResultsReturnedException {
		return courseService.getCourse(courseId);
	}

	@RequestMapping(path = "/courses/{courseId}/students", method = RequestMethod.GET)
	public List<Student> getStudents(@PathVariable("courseId") Integer courseId) {
		return null;
	}

	@RequestMapping(path = "/courses/{courseId}/markers", method = RequestMethod.GET)
	public List<Marker> getMarkers(@PathVariable("courseId") Integer courseId) {
		return null;
	}

	@RequestMapping(path = "/courses/{courseId}/courseOwners", method = RequestMethod.GET)
	public List<CourseOwner> getCourseOwners(@PathVariable("courseId") Integer courseId) {
		return null;
	}

	@RequestMapping(path = "/courses/{courseId}/assignments", method = RequestMethod.GET)
	public List<Assignment> getAssignments(@PathVariable("courseId") Integer courseId) {
		return null;
	}
	@RequestMapping(path = "/courses/{courseId}/assignments/{assignmentId}", method = RequestMethod.GET)
	public Assignment getAssignment(@PathVariable("courseId") Integer courseId, @PathVariable("assignmentId") Integer assignmentId) {
		return null;
	}

	@RequestMapping(path = "/courses/{courseId}/assignments/{assignmentId}/submissions", method = RequestMethod.GET)
	public List<Submission> getSubmissions(@PathVariable("courseId") Integer courseId, @PathVariable("assignmentId") Integer assignmentId) {
		return null;
	}

	@RequestMapping(path = "/courses/{courseId}/assignments/{assignmentId}/submissions/{submissionId}", method = RequestMethod.GET)
	public Submission getSubmission(@PathVariable("courseId") Integer courseId, @PathVariable("assignmentId") Integer assignmentId, @PathVariable("submissionId") Integer submissionId) {
		return null;
	}
}
