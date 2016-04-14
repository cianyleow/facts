package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.assignment.Assignment;

public interface AssignmentDAO extends BaseDAO<Assignment, Integer> {
	public List<Assignment> getAssignments(Course course);

	public void createAssignmentFile(Integer assignmentId, File file);
}
