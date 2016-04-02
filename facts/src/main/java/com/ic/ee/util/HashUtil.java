package com.ic.ee.util;

import org.springframework.web.multipart.MultipartFile;

import com.ic.ee.core.web.exception.HashingException;

public interface HashUtil {
	public String getHash(String message);

	public String getHash(MultipartFile file) throws HashingException;
}
