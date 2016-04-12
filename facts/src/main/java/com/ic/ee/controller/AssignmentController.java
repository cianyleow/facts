package com.ic.ee.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.SubmissionFileMatchException;
import com.ic.ee.core.web.exception.SubmissionFileValidationException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.core.web.exception.UnmatchableSetsException;
import com.ic.ee.domain.common.feedback.mark.MarkComponent;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.common.file.FileRequirement;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.service.api.AssignmentService;
import com.ic.ee.service.api.SubmissionService;

@RestController
public class AssignmentController {
	private final static Logger logger = Logger.getLogger(AssignmentController.class);

	@Autowired
	private AssignmentService assignmentService;

	@Autowired
	private SubmissionService submissionService;

	@RequestMapping(path = "/assignments/{assignmentId}", method = RequestMethod.GET)
	public Assignment getAssignment(@PathVariable("assignmentId") Integer assignmentId) throws NoResultsReturnedException, TooManyResultsReturnedException {
		return assignmentService.getAssignment(assignmentId, true);
	}

	@RequestMapping(path = "/assignments/{assignmentId}/requiredFiles", method = RequestMethod.GET)
	public List<FileRequirement> getAssignmentRequiredFiles(@PathVariable("assignmentId") Integer assignmentId) throws NoResultsReturnedException, TooManyResultsReturnedException {
		return assignmentService.getAssignment(assignmentId, false).getRequiredFiles();
	}

	@RequestMapping(path = "/assignments/{assignmentId}/markComponents", method = RequestMethod.GET)
	public List<MarkComponent> getMarkComponents(@PathVariable("assignmentId") Integer assignmentId) throws NoResultsReturnedException, TooManyResultsReturnedException {
		return assignmentService.getAssignment(assignmentId, false).getMarkComponents();
	}

	@RequestMapping(path = "/assignments/{assignmentId}/suppliedFiles", method = RequestMethod.GET)
	public List<File> getSuppliedFiles(@PathVariable("assignmentId") Integer assignmentId) throws NoResultsReturnedException, TooManyResultsReturnedException {
		return assignmentService.getAssignment(assignmentId, false).getSuppliedFiles();
	}

	@RequestMapping(path = "/assignments/{assignmentId}/suppliedFiles", method = RequestMethod.POST)
	public File addRequiredFiles(@PathVariable("assignmentId") Integer assignmentId, @RequestParam("file") MultipartFile file, Principal user) throws IncorrectFileNameFormatException, FileUploadException, HashingException, NoResultsReturnedException, TooManyResultsReturnedException {
		return assignmentService.createSuppliedFile(assignmentId, file, user.getName());
	}

	@RequestMapping(path = "/assignments/{assignmentId}/submissions", method = RequestMethod.POST)
	public Submission createSubmission(@PathVariable("assignmentId") Integer assignmentId, @RequestParam("files") MultipartFile[] files, @RequestParam("submission") String submissionString, Principal user) throws NoResultsReturnedException, TooManyResultsReturnedException, JsonParseException, JsonMappingException, IOException, SubmissionFileMatchException, UnmatchableSetsException, SubmissionFileValidationException, IncorrectFileNameFormatException, FileUploadException, HashingException {
		Submission submission = new ObjectMapper().readValue(submissionString, Submission.class);
		return submissionService.createSubmission(assignmentId, submission, files, "cyl312"/*user.getName()*/);
	}
}
