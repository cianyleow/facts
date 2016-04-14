package com.ic.ee.domain.user.courseowner;

import java.util.Set;

import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.marker.Marker;

public class CourseOwner extends Marker {

	public CourseOwner() {
		// TODO Auto-generated constructor stub
	}

	private Set<Course> coursesOwned;

	public CourseOwner(String userName) {
		super(userName);
	}

	public Set<Course> getCoursesOwned() {
		return coursesOwned;
	}
}
