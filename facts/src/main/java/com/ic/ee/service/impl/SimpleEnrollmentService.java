package com.ic.ee.service.impl;

import java.util.List;

import com.ic.ee.core.dao.api.CourseDAO;
import com.ic.ee.core.dao.api.EnrollmentDAO;
import com.ic.ee.core.dao.api.StudentDAO;
import com.ic.ee.domain.common.relationship.Enrollment;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.student.Student;
import com.ic.ee.service.api.EnrollmentService;
import com.ic.ee.util.collection.CollectionUtil;
import com.ic.ee.util.collection.Extractor;
import com.ic.ee.util.collection.Matcher;
import com.ic.ee.util.collection.Setter;

public class SimpleEnrollmentService implements EnrollmentService {

	private final EnrollmentDAO enrollmentDAO;

	private final CourseDAO courseDAO;

	private final StudentDAO studentDAO;

	public SimpleEnrollmentService(EnrollmentDAO enrollmentDAO, CourseDAO courseDAO, StudentDAO studentDAO) {
		this.enrollmentDAO = enrollmentDAO;
		this.courseDAO = courseDAO;
		this.studentDAO = studentDAO;
	}

	@Override
	public Enrollment getEnrollment(Integer courseId, String username) {
		return enrollmentDAO.getEnrollment(courseId, username);
	}

	@Override
	public List<Enrollment> getEnrollments(String username) {
		return enrollmentDAO.getEnrollments(new Student(username));
	}

	@Override
	public Enrollment getEnrollment(Integer enrollmentId) {
		return enrollmentDAO.one(enrollmentId);
	}

	@Override
	public Enrollment createEnrollment(Enrollment enrollment) {
		return enrollmentDAO.create(enrollment);
	}

	@Override
	public Enrollment updateEnrollment(Integer enrollmentId, Enrollment enrollment) {
		enrollment.setEnrollmentId(enrollmentId);
		return enrollmentDAO.update(enrollment);
	}

	@Override
	public void deleteEnrollment(Integer enrollmentId) {
		enrollmentDAO.delete(enrollmentId);
	}

	@Override
	public List<Enrollment> decorateCourses(List<Enrollment> enrollments) {
		if(enrollments == null || enrollments.isEmpty()) {
			return enrollments;
		}
		List<Integer> courseIds = CollectionUtil.extractAttribute(enrollments, new Extractor<Enrollment, Integer>() {

			@Override
			public Integer extract(Enrollment element) {
				if(element.getCourse() != null) {
					return element.getCourse().getCourseId();
				}
				return -1;
			}

		});
		List<Course> courses = courseDAO.several(courseIds);
		return CollectionUtil.matchSets(enrollments, courses, new Matcher<Enrollment, Course>() {

			@Override
			public boolean matches(Enrollment elementOne, Course elementTwo) {
				return elementOne != null &&
						elementTwo != null &&
						elementOne.getCourse() != null &&
						elementOne.getCourse().getCourseId() != null &&
						elementTwo.getCourseId() != null &&
						elementOne.getCourse().getCourseId().equals(elementTwo.getCourseId());
			}

		}, new Setter<Enrollment, Course>() {

			@Override
			public void set(Enrollment element, Course attribute) {
				if(element != null) {
					element.setCourse(attribute);
				}
			}

		});
	}

	@Override
	public List<Enrollment> decorateStudents(List<Enrollment> enrollments) {
		if(enrollments == null || enrollments.isEmpty()) {
			return enrollments;
		}
		List<String> usernames = CollectionUtil.extractAttribute(enrollments, new Extractor<Enrollment, String>() {

			@Override
			public String extract(Enrollment element) {
				if(element.getStudent() != null) {
					return element.getStudent().getUserName();
				}
				return null;
			}

		});
		List<Student> students = studentDAO.several(usernames);
		return CollectionUtil.matchSets(enrollments, students, new Matcher<Enrollment, Student>() {

			@Override
			public boolean matches(Enrollment elementOne, Student elementTwo) {
				return elementOne != null &&
						elementTwo != null &&
						elementOne.getStudent() != null &&
						elementOne.getStudent().getUserName() != null &&
						elementTwo.getUserName() != null &&
						elementOne.getStudent().getUserName().equals(elementTwo.getUserName());
			}

		}, new Setter<Enrollment, Student>() {

			@Override
			public void set(Enrollment element, Student attribute) {
				if(element != null) {
					element.setStudent(attribute);
				}
			}

		});
	}

}
