package com.ic.ee.core.service.impl;

import java.util.List;

import com.ic.ee.core.jdbc.api.AssignmentDAO;
import com.ic.ee.core.service.api.AssignmentService;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.course.assignment.AssignmentDetails;

public class SimpleAssignmentService implements AssignmentService {

	private final AssignmentDAO assignmentDAO;

	public SimpleAssignmentService(AssignmentDAO assignmentDAO) {
		this.assignmentDAO = assignmentDAO;
	}

	@Override
	public List<AssignmentDetails> getAssignmentDetailsForCourse(Integer courseId) {
		return assignmentDAO.getAssignmentDetailsForCourse(courseId);
	}

	@Override
	public AssignmentDetails getAssignmentDetails(Integer assignmentId) {
		return assignmentDAO.getAssignmentDetails(assignmentId);
	}

	@Override
	public Assignment getAssignment(Integer assignmentId) {
		return null;
	}

}
