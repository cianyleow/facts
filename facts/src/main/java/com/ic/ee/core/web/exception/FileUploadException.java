package com.ic.ee.core.web.exception;

public class FileUploadException extends Exception {

	private final Exception exception;

	public FileUploadException(Exception exception) {
		this.exception = exception;
	}

	@Override
	public String getMessage() {
		return "File Upload Exception: " + getException().getMessage();
	}

	public Exception getException() {
		return exception;
	}
}
