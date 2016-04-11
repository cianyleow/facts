package com.ic.ee.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.SubmissionFileValidationException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.service.api.SubmissionService;

@RestController
public class SubmissionController {

	@Autowired
	private SubmissionService submissionService;

	@RequestMapping(path = "/submissions/{submissionId}/requiredFiles/{fileRequirementId}", method = RequestMethod.POST)
	public File uploadSubmissionFile(@PathVariable("submissionId") Integer submissionId, @PathVariable("fileRequirementId") Integer fileRequirementId, @RequestParam("file") MultipartFile file, Principal user) throws IncorrectFileNameFormatException, FileUploadException, HashingException, SubmissionFileValidationException, NoResultsReturnedException, TooManyResultsReturnedException {
		return submissionService.createSubmissionFile(submissionId, fileRequirementId, file, user.getName());
	}

	@RequestMapping(path = "/submissions/{submissionId}/validate", method = RequestMethod.POST)
	public Submission validateSubmission(@PathVariable("submissionId") Integer submissionId, @RequestBody Submission submission) {
		return submissionService.validateSubmission(submissionId, submission);
	}
//
//	@RequestMapping(path = "/submissions", method = RequestMethod.POST)
//	public void upload(@RequestParam("files") MultipartFile[] files, @RequestParam("submission") String submission) {
//		System.out.println(submission);
////		System.out.println(request.getFiles("files").size());
//	}
}
