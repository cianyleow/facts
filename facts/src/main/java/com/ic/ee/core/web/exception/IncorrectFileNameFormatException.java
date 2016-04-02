package com.ic.ee.core.web.exception;

public class IncorrectFileNameFormatException extends Exception {

	private String fileName;

	public IncorrectFileNameFormatException(String fileName) {
		this.fileName = fileName;
	}



	@Override
	public String getMessage() {
		return "Incorrect file name format for: " + getFileName();
	}



	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
