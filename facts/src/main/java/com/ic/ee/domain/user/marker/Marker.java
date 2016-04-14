package com.ic.ee.domain.user.marker;

import java.util.Set;

import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.User;

public class Marker extends User {

	public Marker() {
		// TODO Auto-generated constructor stub
	}

	public Marker(String userName) {
		super(userName);
	}

	private Set<Course> coursesMarkedFor;
	private String title;

	public Set<Course> getCoursesMarkedFor() {
		return coursesMarkedFor;
	}

	public void setCoursesMarkedFor(Set<Course> coursesMarkedFor) {
		this.coursesMarkedFor = coursesMarkedFor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
