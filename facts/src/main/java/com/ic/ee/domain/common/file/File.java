package com.ic.ee.domain.common.file;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ic.ee.domain.user.User;

public class File {

	private Integer fileId;

	private String name;
	private String extension;

	private String contentType;
	private Long size;
	private String hash;

	private String location;

	private Date creationTime;

	private User owner;

	public File() {
		// TODO Auto-generated constructor stub
	}

	public File(Integer fileId) {
		this.fileId = fileId;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	@JsonIgnore
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
}
