package com.ic.ee.service.api;

import java.util.List;

import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.course.assignment.AssignmentDetails;

public interface AssignmentService {
	public List<AssignmentDetails> getAssignmentDetailsForCourse(Integer courseId);

	public AssignmentDetails getAssignmentDetails(Integer assignmentId);

	public Assignment getAssignment(Integer assignmentId);
}
