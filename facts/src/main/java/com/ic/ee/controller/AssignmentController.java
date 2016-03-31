package com.ic.ee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.feedback.mark.MarkComponent;
import com.ic.ee.domain.common.file.FileRequirement;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.service.api.AssignmentService;

@RestController
public class AssignmentController {

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
}
