package com.ic.ee.core.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.ic.ee.domain.common.file.FileRequirement;
import com.ic.ee.domain.common.file.SubmissionFile;

public class SubmissionFileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return SubmissionFile.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(target == null) {
			errors.rejectValue("value", "Null", "The submission file is null.");
		}
//		ValidationUtils.rejectIfEmpty(errors, "file", "submissionFile.file", "File is empty.");
//		ValidationUtils.rejectIfEmpty(errors, "fileRequirement", "submissionFile.fileRequirement", "File requirement does not exist.");
		SubmissionFile submissionFile = (SubmissionFile) target;
		MultipartFile file = submissionFile.getFile();
		FileRequirement fileRequirement = submissionFile.getFileRequirement();
		// Check file name is valid, etc.
		if(!fileRequirement.getFullAllowedFileName().equalsIgnoreCase(file.getOriginalFilename())) {
			errors.rejectValue("fileName", "fileName.invalid", "The file names do not match.");
		}
		// Check file size is valid.
		if(fileRequirement.getMaxFileSize() < file.getSize()) {
			errors.rejectValue("fileSize", "fileSize.tooLarge", "The file size is too large.");
		}
	}
}
