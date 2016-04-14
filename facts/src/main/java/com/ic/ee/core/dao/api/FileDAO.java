package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.domain.common.file.File;

public interface FileDAO {

	public List<File> getFiles(List<Integer> fileIds);

	public List<File> getSubmissionFiles(Integer submissionId);

	public List<File> getAssignmentFiles(Integer assignmentId);

	public Integer addDownloadLink(File file, String hash, String username);

	public List<File> getFiles(String link);

	public Integer voidDownloadLink(String link);

	public Integer createFile(String username, File file);

}