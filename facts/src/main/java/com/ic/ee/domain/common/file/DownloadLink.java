package com.ic.ee.domain.common.file;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ic.ee.domain.user.User;

public class DownloadLink {

	private Integer downloadLinkId;

	private File file;

	private String link;

	private Timestamp validFrom;

	private User user;

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
