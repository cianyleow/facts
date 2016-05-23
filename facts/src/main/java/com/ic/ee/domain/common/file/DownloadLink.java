package com.ic.ee.domain.common.file;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.ic.ee.domain.Views;
import com.ic.ee.domain.user.User;

public class DownloadLink {

	@JsonView(Views.Public.class)
	private Integer downloadLinkId;

	@JsonIgnore
	private File file;

	@JsonView(Views.Public.class)
	private String link;

	@JsonIgnore
	private Timestamp validFrom;

	@JsonIgnore
	private User user;

	@JsonView(Views.Public.class)
	private Boolean used;

	public DownloadLink() {

	}

	public DownloadLink(Integer downloadLinkId) {
		this.downloadLinkId = downloadLinkId;
	}

	public Integer getDownloadLinkId() {
		return downloadLinkId;
	}

	public void setDownloadLinkId(Integer downloadLinkId) {
		this.downloadLinkId = downloadLinkId;
	}

	@JsonIgnore
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Timestamp getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Timestamp validFrom) {
		this.validFrom = validFrom;
	}

	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean isUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}
}
