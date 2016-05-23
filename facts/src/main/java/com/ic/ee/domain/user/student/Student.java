package com.ic.ee.domain.user.student;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.ic.ee.domain.Views;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.User;

public class Student extends User {

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String userName) {
		super(userName);
	}

	@JsonView(Views.Student.class)
	private Integer studentId;

	@JsonView(Views.Student.class)
	private Integer yearOfStudy;

	@JsonIgnore
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
