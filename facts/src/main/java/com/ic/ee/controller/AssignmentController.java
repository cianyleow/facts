package com.ic.ee.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoMarkersException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.SubmissionFileMatchException;
import com.ic.ee.core.web.exception.SubmissionFileValidationException;
import com.ic.ee.core.web.exception.UnmatchableSetsException;
import com.ic.ee.domain.Views;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.service.api.AssignmentService;
import com.ic.ee.service.api.FeedbackService;
import com.ic.ee.service.api.SubmissionService;
import com.ic.ee.util.marker.impl.RoundRobinAllocator;

@RestController
public class AssignmentController {
	private final static Logger logger = Logger.getLogger(AssignmentController.class);

	@Autowired
	private AssignmentService assignmentService;

	@Autowired
	private SubmissionService submissionService;

	@Autowired
	private FeedbackService feedbackService;

	@JsonView(Views.Public.class)
	@RequestMapping(path = "/assignments/{assignmentId}", method = RequestMethod.GET)
	public Assignment getAssignment(@PathVariable("assignmentId") Integer assignmentId) {
		return assignmentService.getAssignment(assignmentId);
	}

	@RequestMapping(path = "/assignments/{assignmentId}", method = RequestMethod.DELETE)
	public void deleteAssignment(@PathVariable("assignmentId") Integer assignmentId) {
		assignmentService.deleteAssignment(assignmentId);
	}

	@JsonView(Views.CourseOwner.class)
	@PreAuthorize("hasRole('ROLE_COURSE_OWNER')")
	@RequestMapping(path = "/assignments/{assignmentId}/submissions", method = RequestMethod.GET)
	public List<Submission> getSubmission(@PathVariable("assignmentId") Integer assignmentId) {
		return submissionService.getSubmissions(new Assignment(assignmentId));
	}

	@JsonView(Views.Public.class)
	@RequestMapping(path = "/assignments/{assignmentId}/submissions/self", method = RequestMethod.GET)
	public List<Submission> getSubmission(@PathVariable("assignmentId") Integer assignmentId, Principal user) {
		return submissionService.getSubmissions(assignmentId, user.getName());
	}

	@JsonView(Views.Public.class)
	@RequestMapping(path = "/assignments/{assignmentId}/suppliedFiles", method = RequestMethod.POST)
	public File addRequiredFiles(@PathVariable("assignmentId") Integer assignmentId, @RequestParam("file") MultipartFile file, Principal user) throws IncorrectFileNameFormatException, FileUploadException, HashingException, NoResultsReturnedException {
		return assignmentService.createSuppliedFile(assignmentId, file, user.getName());
	}

	@JsonView(Views.Public.class)
	@RequestMapping(path = "/assignments/{assignmentId}/submissions", method = RequestMethod.POST)
	public Submission createSubmission(@PathVariable("assignmentId") Integer assignmentId, @RequestParam("files") MultipartFile[] files, @RequestParam("submission") String submissionString, Principal user) throws NoResultsReturnedException, JsonParseException, JsonMappingException, IOException, SubmissionFileMatchException, UnmatchableSetsException, SubmissionFileValidationException, IncorrectFileNameFormatException, FileUploadException, HashingException {
		Submission submission = new ObjectMapper().readValue(submissionString, Submission.class);
		return submissionService.createSubmission(assignmentId, submission, files, user.getName());
	}

	@JsonView(Views.CourseOwner.class)
	@RequestMapping(path = "/assignments/{assignmentId}/feedback", method = RequestMethod.POST)
	public List<Submission> assignMarkers(@PathVariable("assignmentId") Integer assignmentId) throws NoMarkersException {
		feedbackService.createFeedback(assignmentId, new RoundRobinAllocator());
		return submissionService.getSubmissions(new Assignment(assignmentId));
	}
}
