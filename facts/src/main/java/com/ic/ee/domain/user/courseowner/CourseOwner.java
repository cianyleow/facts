package com.ic.ee.domain.user.courseowner;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.marker.Marker;

public class CourseOwner extends Marker {

	public CourseOwner() {
		// TODO Auto-generated constructor stub
	}

	@JsonIgnore
	private Set<Course> coursesOwned;

	public CourseOwner(String userName) {
		super(userName);
	}

	public Set<Course> getCoursesOwned() {
		return coursesOwned;
	}

	public void setCoursesOwned(Set<Course> coursesOwned) {
		this.coursesOwned = coursesOwned;
	}
}
