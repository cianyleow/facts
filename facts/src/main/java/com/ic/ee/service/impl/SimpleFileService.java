package com.ic.ee.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;

import com.ic.ee.core.dao.api.FileDAO;
import com.ic.ee.core.web.exception.DownloadLinkDoesNotExistException;
import com.ic.ee.core.web.exception.DownloadLinkVoidFailedException;
import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.service.api.FileService;
import com.ic.ee.util.FileUtils;
import com.ic.ee.util.HashUtil;

public class SimpleFileService implements FileService {

	private final FileDAO fileDAO;

	private final HashUtil hashUtil;

	private final FileUtils fileUtils;

	public SimpleFileService(FileDAO fileDAO, HashUtil hashUtil, FileUtils fileUtils) {
		this.fileDAO = fileDAO;
		this.hashUtil = hashUtil;
		this.fileUtils = fileUtils;
	}

	@Override
	public File getFile(Integer fileId) {
		return getFile(fileId);
	}

	@Override
	public String getDownloadLink(Integer fileId, String username) throws NoResultsReturnedException {
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

	@Override
	public File getFile(String link) throws DownloadLinkDoesNotExistException, DownloadLinkVoidFailedException {
		File file = fileDAO.getFileFromLink(link);
		if(file == null) {
			throw new DownloadLinkDoesNotExistException();
		}

		if(fileDAO.voidDownloadLink(link) != 1) {
			throw new DownloadLinkVoidFailedException();
		}

		return file;
	}

	@Override
	public File createFile(MultipartFile file, String username) throws IncorrectFileNameFormatException, FileUploadException, HashingException, NoResultsReturnedException {
		// Create file from multipart file
		File createdFile = fileUtils.createFile(file);

		// Get fileId and decorate created file
		Integer fileId = fileDAO.createFile(username, createdFile);

		return getFile(fileId);
	}

	@Override
	public List<File> getSubmissionFiles(Integer submissionId) {
		return fileDAO.getSubmissionFiles(submissionId);
	}
}