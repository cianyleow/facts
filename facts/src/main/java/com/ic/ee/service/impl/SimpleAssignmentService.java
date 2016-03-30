package com.ic.ee.service.impl;

import com.ic.ee.core.jdbc.api.AssignmentDAO;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.service.api.AssignmentService;

public class SimpleAssignmentService implements AssignmentService {

	private final AssignmentDAO assignmentDAO;

	public SimpleAssignmentService(AssignmentDAO assignmentDAO) {
		this.assignmentDAO = assignmentDAO;
	}

	@Override
	public Assignment getAssignment(Integer assignmentId) {
		return null;
	}

}
