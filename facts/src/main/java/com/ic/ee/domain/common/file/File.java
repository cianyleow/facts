package com.ic.ee.domain.common.file;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.ic.ee.domain.Views;
import com.ic.ee.domain.user.User;

public class File {

	@JsonView(Views.Public.class)
	private Integer fileId;

	@JsonView(Views.Public.class)
	private String name;

	@JsonView(Views.Public.class)
	private String extension;

	@JsonView(Views.Public.class)
	private String contentType;

	@JsonView(Views.Public.class)
	private Long size;

	@JsonView(Views.Public.class)
	private String hash;

	@JsonIgnore
	private String location;

	@JsonView(Views.Public.class)
	private Timestamp creationTime;

	@JsonIgnore
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

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}
}
