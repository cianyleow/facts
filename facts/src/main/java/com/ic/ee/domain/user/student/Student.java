package com.ic.ee.domain.user.student;

import java.util.Set;

import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.User;

public class Student extends User {

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String userName) {
		super(userName);
	}

	private Integer studentId;
	private Integer yearOfStudy;
	private Set<Course> enrolledCourses;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(Integer yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public Set<Course> getEnrolledCourses() {
		return enrolledCourses;
	}

	public void setEnrolledCourses(Set<Course> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}
}
