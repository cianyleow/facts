package com.ic.ee.util;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ic.ee.core.web.exception.EmptyFileException;
import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.domain.common.file.File;

public class SimpleFileUtils implements FileUtils {

	private final String baseFileLocation;

	private final HashUtil hashUtil;

	public SimpleFileUtils(String baseFileLocation, HashUtil hashUtil) {
		this.baseFileLocation = baseFileLocation;
		this.hashUtil = hashUtil;
	}

	@Override
	public File createFile(MultipartFile file) throws IncorrectFileNameFormatException, FileUploadException, HashingException {
		File createdFile = new File();
		createdFile.setName(getFileName(file.getOriginalFilename()));
		createdFile.setExtension(getExtension(file.getOriginalFilename()));
		createdFile.setSize(file.getSize());
		createdFile.setHash(hashUtil.getHash(file));
		createdFile.setContentType(file.getContentType());

		String uploadLocation = uploadFile(createdFile.getHash(), file);
		createdFile.setLocation(uploadLocation );

		return createdFile;
	}

	public String getFileName(String fileName) throws IncorrectFileNameFormatException {
		String[] parts = fileName.split("\\.");
		if(parts.length != 2) {
			throw new IncorrectFileNameFormatException(fileName);
		}
		return parts[0];
	}

	public String getExtension(String fileName) throws IncorrectFileNameFormatException {
		String[] parts = fileName.split("\\.");
		if(parts.length != 2) {
			throw new IncorrectFileNameFormatException(fileName);
		}
		return parts[1];
	}

	private String uploadFile(String hash, MultipartFile file) throws FileUploadException {
		if(file.isEmpty()) {
			throw new FileUploadException(new EmptyFileException());
		}

		String fileLocation = createFileLocation(hash);

		try {
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new java.io.File(fileLocation)));
			FileCopyUtils.copy(file.getInputStream(), stream);
		} catch (IOException e) {
			throw new FileUploadException(e);
		}

		return fileLocation;
	}

	private String createFileLocation(String hash) {
		Date date = new Date();
		String fileLocation = baseFileLocation + "/" + hash + "." + date.getTime();
		return fileLocation;
	}
}
