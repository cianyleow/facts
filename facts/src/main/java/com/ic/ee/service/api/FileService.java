package com.ic.ee.service.api;

import org.springframework.web.multipart.MultipartFile;

import com.ic.ee.core.web.exception.DownloadLinkExpiredException;
import com.ic.ee.core.web.exception.DownloadLinkUsedException;
import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.domain.common.file.DownloadLink;
import com.ic.ee.domain.common.file.File;

public interface FileService {

	public DownloadLink createDownloadLink(Integer fileId, String username);

	public File getFile(Integer fileId);

	public DownloadLink getDownloadLink(String link) throws DownloadLinkUsedException, DownloadLinkExpiredException;

	public File createFile(MultipartFile file, String username) throws IncorrectFileNameFormatException, FileUploadException, HashingException, NoResultsReturnedException;
}
