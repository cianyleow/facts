package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.course.assignment.Assignment;

public interface AssignmentDAO {

	public List<Assignment> getAssignments(List<Integer> assignmentIds);

	public List<Assignment> getAssignments(Integer courseId);

	public List<Integer> getSuppliedFileIds(Integer assignmentId);

	public Integer createAssignment(Integer courseId, Assignment assignment);

	public void createAssignmentFile(Integer assignmentId, File file);
}
