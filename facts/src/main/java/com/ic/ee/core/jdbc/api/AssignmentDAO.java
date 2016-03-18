package com.ic.ee.core.jdbc.api;

import java.util.List;

import com.ic.ee.domain.course.assignment.AssignmentDetails;

public interface AssignmentDAO {

	public List<AssignmentDetails> getAssignmentDetailsForCourse(Integer courseId);

	public AssignmentDetails getAssignmentDetails(Integer assignmentId);
}
