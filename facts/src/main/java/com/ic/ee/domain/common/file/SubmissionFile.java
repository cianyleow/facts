package com.ic.ee.domain.common.file;

import org.springframework.web.multipart.MultipartFile;

/*
 * A MultipartFile + a FileRequirement and validate that they are okay.
 *
 */

public class SubmissionFile {

	private final MultipartFile file;

	private final FileRequirement fileRequirement;

	public SubmissionFile(MultipartFile file, FileRequirement fileRequirement) {
		this.file = file;
		this.fileRequirement = fileRequirement;
	}

	public MultipartFile getFile() {
		return file;
	}

	public FileRequirement getFileRequirement() {
		return fileRequirement;
	}
}
