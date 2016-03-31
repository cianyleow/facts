package com.ic.ee.service.impl;

import java.util.Collections;
import java.util.List;

import com.ic.ee.core.jdbc.api.FileDAO;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.service.api.FileService;

public class SimpleFileService implements FileService {

	private final FileDAO fileDAO;

	public SimpleFileService(FileDAO fileDAO) {
		this.fileDAO = fileDAO;
	}

	@Override
	public List<File> getFiles(List<Integer> fileIds) {
		if(fileIds == null || fileIds.isEmpty()) {
			return Collections.emptyList();
		}
		return fileDAO.getFiles(fileIds);
	}

}
