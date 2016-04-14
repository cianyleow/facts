package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.course.assignment.Assignment;

public interface AssignmentDAO extends BaseDAO<Assignment, Integer> {

	public Integer createAssignment(Integer courseId, Assignment assignment);

	public List<Assignment> getAssignments(Integer courseId);

	public void createAssignmentFile(Integer assignmentId, File file);
}
