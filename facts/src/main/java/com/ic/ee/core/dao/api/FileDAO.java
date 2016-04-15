package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.course.assignment.submission.Submission;

public interface FileDAO extends BaseDAO<File, Integer> {

	public List<File> getFiles(Submission submission);

	public List<File> getFiles(Assignment assignment);

}
