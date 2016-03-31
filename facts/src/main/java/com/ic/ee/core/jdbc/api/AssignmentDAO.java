package com.ic.ee.core.jdbc.api;

import java.util.List;

import com.ic.ee.domain.common.file.FileRequirement;
import com.ic.ee.domain.course.assignment.Assignment;

public interface AssignmentDAO {

	public List<Assignment> getAssignments(List<Integer> assignmentIds);

	public List<Assignment> getAssignments(Integer courseId);

	public List<FileRequirement> getRequiredFiles(Integer assignmentId);

}
