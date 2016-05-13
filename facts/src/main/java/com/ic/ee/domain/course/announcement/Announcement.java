package com.ic.ee.domain.course.announcement;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.courseowner.CourseOwner;

public class Announcement {

	private Integer announcementId;

	private Course course;

	private String content;

	private String link;

	private Timestamp creationTime;

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

	@JsonIgnore
	public Course getCourse() {
		return course;
	}

	@JsonProperty
	public void setCourse(Course course) {
		this.course = course;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	@JsonIgnore
	public CourseOwner getCourseOwner() {
		return courseOwner;
	}

	@JsonProperty
	public void setCourseOwner(CourseOwner courseOwner) {
		this.courseOwner = courseOwner;
	}
}
