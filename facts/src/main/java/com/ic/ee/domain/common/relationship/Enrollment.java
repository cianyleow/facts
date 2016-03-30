package com.ic.ee.domain.common.relationship;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.student.Student;

public class Enrollment {
	public Integer enrollmentId;

	public Student student;

	public Course course;

	public EnrollmentLevel enrollmentLevel;

	public Date updateTime;

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

	@JsonIgnore
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@JsonProperty
	public Integer getCourseId() {
		return course.getCourseId();
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
