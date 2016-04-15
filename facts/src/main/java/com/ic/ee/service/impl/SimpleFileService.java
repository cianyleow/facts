package com.ic.ee.service.impl;

import java.util.Date;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;

import com.ic.ee.core.dao.api.DownloadLinkDAO;
import com.ic.ee.core.dao.api.FileDAO;
import com.ic.ee.core.web.exception.DownloadLinkExpiredException;
import com.ic.ee.core.web.exception.DownloadLinkUsedException;
import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.domain.common.file.DownloadLink;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.user.User;
import com.ic.ee.service.api.FileService;
import com.ic.ee.util.FileUtils;
import com.ic.ee.util.HashUtil;

public class SimpleFileService implements FileService {

	private final FileDAO fileDAO;

	private final DownloadLinkDAO downloadLinkDAO;

	private final HashUtil hashUtil;

	private final FileUtils fileUtils;

	public SimpleFileService(FileDAO fileDAO, DownloadLinkDAO downloadLinkDAO, HashUtil hashUtil, FileUtils fileUtils) {
		this.fileDAO = fileDAO;
		this.downloadLinkDAO = downloadLinkDAO;
		this.hashUtil = hashUtil;
		this.fileUtils = fileUtils;
	}

	@Override
	public File getFile(Integer fileId) {
		return fileDAO.one(fileId);
	}

	@Override
	public DownloadLink createDownloadLink(Integer fileId, String username) {
		File file = getFile(fileId);
		Date date = new Date();
		Random rand = new Random();
		Integer nonce = rand.nextInt();
		String toHash = file.getName() + "." + username + "." + date.getTime() + "." + nonce;
		String link = hashUtil.getHash(toHash);
		DownloadLink downloadLink = new DownloadLink();
		downloadLink.setFile(file);
		downloadLink.setLink(link);
		downloadLink.setUser(new User(username));
		return downloadLinkDAO.create(downloadLink);
	}

	@Override
	public DownloadLink getDownloadLink(String link) throws DownloadLinkUsedException, DownloadLinkExpiredException {
		DownloadLink downloadLink = downloadLinkDAO.getDownloadLink(link);
		if(downloadLink.isUsed()) {
			throw new DownloadLinkUsedException();
		} else {
			downloadLink.setUsed(true);
		}

		Date validTill = new Date(downloadLink.getValidFrom().getTime() + 30 * 1000);

		if(validTill.before(new Date())) {
			throw new DownloadLinkExpiredException();
		}

		downloadLinkDAO.update(downloadLink);
		decorateDownloadLink(downloadLink);

		return downloadLink;
	}

	private void decorateDownloadLink(DownloadLink downloadLink) {
		downloadLink.setFile(fileDAO.one(downloadLink.getFile().getFileId()));
	}

	@Override
	public File createFile(MultipartFile file, String username) throws IncorrectFileNameFormatException, FileUploadException, HashingException, NoResultsReturnedException {
		// Create file from multipart file
		File createdFile = fileUtils.createFile(file);

		// Decorate file with owner
		createdFile.setOwner(new User(username));

		// Get fileId and decorate created file
		return fileDAO.create(createdFile);
	}
}