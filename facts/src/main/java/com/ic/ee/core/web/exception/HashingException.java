package com.ic.ee.core.web.exception;

public class HashingException extends Exception {

	private final Exception exception;

	public HashingException(Exception exception) {
		this.exception = exception;
	}

	@Override
	public String getMessage() {
		return "Hashing Exception: " + getException().getMessage();
	}

	public Exception getException() {
		return exception;
	}
}
