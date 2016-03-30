package com.ic.ee.service.api;

import java.util.List;

import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.course.assignment.Assignment;

public interface AssignmentService {

	public Assignment getAssignment(Integer assignmentId) throws NoResultsReturnedException, TooManyResultsReturnedException;

	public List<Assignment> getAssignments(Integer courseId);
}
