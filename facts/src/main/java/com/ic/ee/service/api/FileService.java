package com.ic.ee.service.api;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ic.ee.core.web.exception.DownloadLinkDoesNotExistException;
import com.ic.ee.core.web.exception.DownloadLinkVoidFailedException;
import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.file.File;

public interface FileService {

	public List<File> getFiles(List<Integer> fileIds);

	public File getFile(Integer fileId) throws NoResultsReturnedException, TooManyResultsReturnedException;

	public String getDownloadLink(Integer fileId, String username) throws NoResultsReturnedException, TooManyResultsReturnedException;

	public File getFile(String link) throws DownloadLinkDoesNotExistException, DownloadLinkVoidFailedException;

	public File createFile(MultipartFile file, String username) throws IncorrectFileNameFormatException, FileUploadException, HashingException;
}
