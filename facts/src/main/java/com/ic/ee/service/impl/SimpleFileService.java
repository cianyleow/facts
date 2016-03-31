package com.ic.ee.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.ic.ee.core.jdbc.api.FileDAO;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.service.api.FileService;
import com.ic.ee.util.ElementExtractor;
import com.ic.ee.util.HashUtil;

public class SimpleFileService implements FileService {

	private final FileDAO fileDAO;

	private final HashUtil hashUtil;

	public SimpleFileService(FileDAO fileDAO, HashUtil hashUtil) {
		this.fileDAO = fileDAO;
		this.hashUtil = hashUtil;
	}

	@Override
	public List<File> getFiles(List<Integer> fileIds) {
		if(fileIds == null || fileIds.isEmpty()) {
			return Collections.emptyList();
		}
		return fileDAO.getFiles(fileIds);
	}

	@Override
	public File getFile(Integer fileId) throws NoResultsReturnedException, TooManyResultsReturnedException {
		List<File> files = getFiles(Collections.singletonList(fileId));
		return ElementExtractor.extractOne(files);
	}

	@Override
	public String getDownloadLink(Integer fileId, String username) throws NoResultsReturnedException, TooManyResultsReturnedException {
		File file = getFile(fileId);
		Date date = new Date();
		Random rand = new Random();
		Integer nonce = rand.nextInt();
		String toHash = file.getName() + "." + username + "." + date.getTime() + "." + nonce;
		String hash = hashUtil.getHash(toHash);
		Integer downloadLinkId = fileDAO.addDownloadLink(file, hash, username);
		if(downloadLinkId == null || downloadLinkId < 0) {
			throw new NoResultsReturnedException();
		}
		return hash;
	}
}