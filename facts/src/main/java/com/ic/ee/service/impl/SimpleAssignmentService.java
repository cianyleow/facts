package com.ic.ee.service.impl;

import java.util.Collections;
import java.util.List;

import com.ic.ee.core.jdbc.api.AssignmentDAO;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.feedback.mark.MarkComponent;
import com.ic.ee.domain.common.file.FileRequirement;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.service.api.AssignmentService;
import com.ic.ee.util.ElementExtractor;

public class SimpleAssignmentService implements AssignmentService {

	private final AssignmentDAO assignmentDAO;

	public SimpleAssignmentService(AssignmentDAO assignmentDAO) {
		this.assignmentDAO = assignmentDAO;
	}

	@Override
	public Assignment getAssignment(Integer assignmentId) throws NoResultsReturnedException, TooManyResultsReturnedException {
		List<Assignment> assignments = assignmentDAO.getAssignments(Collections.singletonList(assignmentId));
		return ElementExtractor.extractOne(assignments);
	}

	@Override
	public List<Assignment> getAssignments(Integer courseId) {
		return assignmentDAO.getAssignments(courseId);
	}

	@Override
	public List<FileRequirement> getRequiredFiles(Integer assignmentId) {
		return assignmentDAO.getRequiredFiles(assignmentId);
	}

	@Override
	public List<MarkComponent> getMarkComponents(Integer assignmentId) {
		return assignmentDAO.getMarkComponents(assignmentId);
	}
}
