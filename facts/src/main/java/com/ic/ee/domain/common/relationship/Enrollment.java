package com.ic.ee.domain.common.relationship;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.student.Student;

public class Enrollment {
	private Integer enrollmentId;

	private Student student;

	private Course course;

	private EnrollmentLevel enrollmentLevel;

	private Date updateTime;

	public Enrollment() {
		// TODO Auto-generated constructor stub
	}

	public Enrollment(Integer enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public Integer getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(Integer enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	@JsonIgnore
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public EnrollmentLevel getEnrollmentLevel() {
		return enrollmentLevel;
	}

	public void setEnrollmentLevel(EnrollmentLevel enrollmentLevel) {
		this.enrollmentLevel = enrollmentLevel;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
