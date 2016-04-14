package com.ic.ee.service.api;

import org.springframework.web.multipart.MultipartFile;

import com.ic.ee.core.web.exception.DownloadLinkDoesNotExistException;
import com.ic.ee.core.web.exception.DownloadLinkVoidFailedException;
import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.domain.common.file.DownloadLink;
import com.ic.ee.domain.common.file.File;

public interface FileService {

	public DownloadLink createDownloadLink(Integer fileId, String username);

	public File getFile(Integer fileId);

	public File getFile(String link) throws DownloadLinkDoesNotExistException, DownloadLinkVoidFailedException;

	public File createFile(MultipartFile file, String username) throws IncorrectFileNameFormatException, FileUploadException, HashingException, NoResultsReturnedException;
}
