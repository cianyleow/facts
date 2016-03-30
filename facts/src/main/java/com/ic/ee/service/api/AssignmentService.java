package com.ic.ee.service.api;

import java.util.List;

import com.ic.ee.domain.course.assignment.Assignment;

public interface AssignmentService {

	public Assignment getAssignment(Integer assignmentId);

	public List<Assignment> getAssignments();

	public List<Assignment> getAssignments(Integer courseId);
}
