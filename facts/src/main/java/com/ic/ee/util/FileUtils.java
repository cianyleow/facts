package com.ic.ee.util;

import org.springframework.web.multipart.MultipartFile;

import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.domain.common.file.File;

public interface FileUtils {

	public File createFile(MultipartFile file) throws IncorrectFileNameFormatException, FileUploadException, HashingException;

	public String getFileLocation(String systemFileName);

}
