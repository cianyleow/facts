package com.ic.ee.domain.course.announcement;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonView;
import com.ic.ee.domain.Views;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.courseowner.CourseOwner;

public class Announcement {

	@JsonView(Views.Public.class)
	private Integer announcementId;

	@JsonView(Views.Student.class)
	private Course course;

	@JsonView(Views.Student.class)
	private String content;

	@JsonView(Views.Student.class)
	private String title;

	@JsonView(Views.Student.class)
	private Timestamp creationTime;

	@JsonView(Views.Student.class)
	private CourseOwner courseOwner;

	public Announcement() { }

	public Announcement(Integer announcementId) {
		this.announcementId = announcementId;
	}

	public Integer getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(Integer announcementId) {
		this.announcementId = announcementId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public CourseOwner getCourseOwner() {
		return courseOwner;
	}

	public void setCourseOwner(CourseOwner courseOwner) {
		this.courseOwner = courseOwner;
	}
}
