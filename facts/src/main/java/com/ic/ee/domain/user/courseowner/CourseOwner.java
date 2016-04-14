package com.ic.ee.domain.user.courseowner;

import java.util.Set;

import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.User;

public class CourseOwner extends User {

	public CourseOwner() {
		// TODO Auto-generated constructor stub
	}

	private String title;

	private Set<Course> coursesOwned;

	private Integer telephoneNumber;

	public CourseOwner(String userName) {
		super(userName);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Course> getCoursesOwned() {
		return coursesOwned;
	}

	public void setCoursesOwned(Set<Course> coursesOwned) {
		this.coursesOwned = coursesOwned;
	}

	public Integer getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(Integer telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
}
