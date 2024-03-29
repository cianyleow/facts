package com.ic.ee.domain.common.file;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.ic.ee.domain.Views;
import com.ic.ee.domain.course.assignment.Assignment;

public class FileRequirement {

	@JsonView(Views.Public.class)
	private Integer fileRequirementId;

	@JsonIgnore
	private Assignment assignment;

	@JsonView(Views.Public.class)
	private String fileName;

	@JsonView(Views.Public.class)
	private Integer maxFileSize;

	@JsonView(Views.Public.class)
	private String allowedExtension;

	public FileRequirement() {
		// TODO Auto-generated constructor stub
	}

	public FileRequirement(Integer fileRequirementId) {
		this.fileRequirementId = fileRequirementId;
	}

	public Integer getFileRequirementId() {
		return fileRequirementId;
	}

	public void setFileRequirementId(Integer fileRequirementId) {
		this.fileRequirementId = fileRequirementId;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getMaxFileSize() {
		return maxFileSize;
	}

	public void setMaxFileSize(Integer maxFileSize) {
		this.maxFileSize = maxFileSize;
	}

	public String getAllowedExtension() {
		return allowedExtension;
	}

	public void setAllowedExtension(String allowedExtension) {
		this.allowedExtension = allowedExtension;
	}

	@JsonIgnore
	public String getFullAllowedFileName() {
		return getFileName() + "." + getAllowedExtension();
	}
}
