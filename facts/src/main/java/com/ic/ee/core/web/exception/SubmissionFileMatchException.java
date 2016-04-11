package com.ic.ee.core.web.exception;

import org.springframework.web.multipart.MultipartFile;

public class SubmissionFileMatchException extends Exception {

	private final MultipartFile file;

	public SubmissionFileMatchException(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String getMessage() {
		return "File matching exception: " + file.getOriginalFilename();
	}

}
