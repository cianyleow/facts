package com.ic.ee.domain.common.file;

public class FileRequirement {

	private Integer fileRequirementId;
	private String fileName;
	private Integer maxFileSize;
	private String allowedExtension;

	public Integer getFileRequirementId() {
		return fileRequirementId;
	}

	public void setFileRequirementId(Integer fileRequirementId) {
		this.fileRequirementId = fileRequirementId;
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
}
