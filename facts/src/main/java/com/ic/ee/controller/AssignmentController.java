package com.ic.ee.controller;

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

import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.feedback.mark.MarkComponent;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.common.file.FileRequirement;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.service.api.AssignmentService;

@RestController
public class AssignmentController {
	private final static Logger logger = Logger.getLogger(AssignmentController.class);

	@Autowired
	private AssignmentService assignmentService;

	@RequestMapping(path = "/assignments/{assignmentId}", method = RequestMethod.GET)
	public Assignment getAssignment(@PathVariable("assignmentId") Integer assignmentId) throws NoResultsReturnedException, TooManyResultsReturnedException {
		return assignmentService.getAssignment(assignmentId);
	}

	@RequestMapping(path = "/assignments/{assignmentId}/requiredFiles", method = RequestMethod.GET)
	public List<FileRequirement> getAssignmentRequiredFiles(@PathVariable("assignmentId") Integer assignmentId) {
		return assignmentService.getRequiredFiles(assignmentId);
	}

	@RequestMapping(path = "/assignments/{assignmentId}/markComponents", method = RequestMethod.GET)
	public List<MarkComponent> getMarkComponents(@PathVariable("assignmentId") Integer assignmentId) {
		return assignmentService.getMarkComponents(assignmentId);
	}

	@RequestMapping(path = "/assignments/{assignmentId}/suppliedFiles", method = RequestMethod.GET)
	public List<File> getSuppliedFiles(@PathVariable("assignmentId") Integer assignmentId) {
		return assignmentService.getSuppliedFiles(assignmentId);
	}

	@RequestMapping(path = "/assignments/{assignmentId}/suppliedFiles", method = RequestMethod.POST)
	public File addRequiredFiles(@PathVariable("assignmentId") Integer assignmentId, @RequestParam("file") MultipartFile file, Principal user) throws IncorrectFileNameFormatException, FileUploadException, HashingException {
		return assignmentService.createSuppliedFile(assignmentId, file, user.getName());
	}
}
