package com.ic.ee.domain.course;

import java.util.Set;

import com.ic.ee.domain.common.AcademicPeriod;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.user.courseowner.CourseOwner;
import com.ic.ee.domain.user.marker.Marker;
import com.ic.ee.domain.user.student.Student;

public class Course {

	private Integer courseId;

	private String name;
	private String shortName;
	private String description;

	private AcademicPeriod academicPeriod;

	private Set<Marker> markers;
	private Set<Student> students;
	private Set<CourseOwner> courseOwners;

	private Set<Assignment> assignments;

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AcademicPeriod getAcademicPeriod() {
		return academicPeriod;
	}

	public void setAcademicPeriod(AcademicPeriod academicPeriod) {
		this.academicPeriod = academicPeriod;
	}

	public Set<Marker> getMarkers() {
		return markers;
	}

	public void setMarkers(Set<Marker> markers) {
		this.markers = markers;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<CourseOwner> getCourseOwners() {
		return courseOwners;
	}

	public void setCourseOwners(Set<CourseOwner> courseOwners) {
		this.courseOwners = courseOwners;
	}

	public Set<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}
}
