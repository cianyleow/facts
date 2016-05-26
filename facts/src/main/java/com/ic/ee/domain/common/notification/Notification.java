package com.ic.ee.domain.common.notification;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonView;
import com.ic.ee.domain.Views;

public class Notification {

	@JsonView(Views.Public.class)
	private Integer notificationId;

	@JsonView(Views.Public.class)
	private String title;

	@JsonView(Views.Public.class)
	private String content;

	@JsonView(Views.Public.class)
	private String link;

	@JsonView(Views.Public.class)
	private Boolean seen;

	@JsonView(Views.Public.class)
	private Timestamp creationTime;

	public Notification(Integer notificationId) {
		this.notificationId = notificationId;
	}

	public Notification() {
	}

	public Integer getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Boolean getSeen() {
		return seen;
	}

	public void setSeen(Boolean seen) {
		this.seen = seen;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}
}
