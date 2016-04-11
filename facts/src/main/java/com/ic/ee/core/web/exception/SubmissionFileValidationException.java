package com.ic.ee.core.web.exception;

import java.util.Collections;
import java.util.List;

import org.springframework.validation.ObjectError;

public class SubmissionFileValidationException extends Exception {

	private final List<ObjectError> errors;

	public SubmissionFileValidationException(List<ObjectError> errors) {
		if(errors == null) {
			this.errors = Collections.emptyList();
		} else {
			this.errors = errors;
		}
	}

	@Override
	public String getMessage() {
		String message = "Submission File Validation:";
		for(ObjectError error : errors) {
			message += "\n - " + error.getDefaultMessage();
		}
		return message;
	}



}
