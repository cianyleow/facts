package com.ic.ee.service.api;

import java.util.List;

import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.file.File;

public interface FileService {

	public List<File> getFiles(List<Integer> fileIds);

	public File getFile(Integer fileId) throws NoResultsReturnedException, TooManyResultsReturnedException;

	public String getDownloadLink(Integer fileId, String username) throws NoResultsReturnedException, TooManyResultsReturnedException;
}
