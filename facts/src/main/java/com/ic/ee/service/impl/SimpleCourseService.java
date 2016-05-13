
package com.ic.ee.service.impl;

import java.util.List;

import com.ic.ee.core.dao.api.AnnouncementDAO;
import com.ic.ee.core.dao.api.AssignmentDAO;
import com.ic.ee.core.dao.api.CourseDAO;
import com.ic.ee.core.dao.api.CourseOwnerDAO;
import com.ic.ee.core.dao.api.EnrollmentDAO;
import com.ic.ee.core.dao.api.MarkerDAO;
import com.ic.ee.core.dao.api.StudentDAO;
import com.ic.ee.domain.common.relationship.Enrollment;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.announcement.Announcement;
import com.ic.ee.domain.user.student.Student;
import com.ic.ee.service.api.CourseService;

public class SimpleCourseService implements CourseService {

	private final CourseDAO courseDAO;

	private final AssignmentDAO assignmentDAO;

	private final MarkerDAO markerDAO;

	private final CourseOwnerDAO courseOwnerDAO;

	private final EnrollmentDAO enrollmentDAO;

	private final StudentDAO studentDAO;

	private final AnnouncementDAO announcementDAO;

	public SimpleCourseService(CourseDAO courseDAO, AssignmentDAO assignmentDAO, MarkerDAO markerDAO,
			CourseOwnerDAO courseOwnerDAO, EnrollmentDAO enrollmentDAO, StudentDAO studentDAO, AnnouncementDAO announcementDAO) {
		this.courseDAO = courseDAO;
		this.assignmentDAO = assignmentDAO;
		this.markerDAO = markerDAO;
		this.courseOwnerDAO = courseOwnerDAO;
		this.enrollmentDAO = enrollmentDAO;
		this.studentDAO = studentDAO;
		this.announcementDAO = announcementDAO;
	}

	@Override
	public Course getLiteCourse(Integer courseId) {
		return courseDAO.one(courseId);
	}

	@Override
	public Course getCourse(Integer courseId){
		Course course = courseDAO.one(courseId);
		decorateCourse(course);
		return course;
	}

	@Override
	public List<Course> getCourses() {
		return courseDAO.getCourses();
	}

	@Override
	public List<Enrollment> getEnrollments(String username) {
		return enrollmentDAO.getEnrollments(new Student(username));
	}

	@Override
	public List<Course> getOwnedCourses(String username) {
		return courseDAO.getOwned(username);
	}

	@Override
	public List<Course> getMarkedCourses(String username) {
		return courseDAO.getMarked(username);
	}

	@Override
	public Announcement createAnnouncement(Integer courseId, Announcement announcement) {
		announcement.setCourse(new Course(courseId));
		return announcementDAO.create(announcement);
	}

	private void decorateCourse(Course course) {
		// Decorate assignments
		course.setAssignments(assignmentDAO.getAssignments(course));

		// Decorate markers
		course.setMarkers(markerDAO.getMarkers(course));

		// Decorate course owner
		course.setCourseOwners(courseOwnerDAO.getCourseOwners(course));

		// Decorate enrollments
		course.setEnrollments(enrollmentDAO.getEnrollments(course));

		// Decorate students
		course.setStudents(studentDAO.getStudents(course));

		// Decorate announcements
		course.setAnnouncements(announcementDAO.getAnnouncements(course));

	}
}
