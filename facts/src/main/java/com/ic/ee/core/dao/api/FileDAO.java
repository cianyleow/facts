package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.common.file.File;

public interface FileDAO extends BaseDAO<File, Integer> {

	public List<File> getSubmissionFiles(Integer submissionId);

	public List<File> getAssignmentFiles(Integer assignmentId);

	public Integer addDownloadLink(File file, String hash, String username);

	public File getFileFromLink(String link);

	public Integer voidDownloadLink(String link);

}
