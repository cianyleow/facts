package com.ic.ee.util;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.web.multipart.MultipartFile;

import com.ic.ee.core.web.exception.HashingException;

public class Sha256HashUtil implements HashUtil {

	private final MessageDigest md;

	public Sha256HashUtil() throws NoSuchAlgorithmException {
		this.md = MessageDigest.getInstance("SHA-256");
	}

	@Override
	public String getHash(String message) {
		md.update(message.getBytes());
		byte byteData[] = md.digest();
		return bytesToString(byteData);
	}

	private String bytesToString(byte byteData[]) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xFF) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

	@Override
	public String getHash(MultipartFile file) throws HashingException {
		try {
			InputStream is = file.getInputStream();
			byte[] dataBytes = new byte[1024];
			int nread = 0;
			while((nread = is.read(dataBytes)) != -1) {
				md.update(dataBytes, 0, nread);
			}
		} catch (IOException e) {
			throw new HashingException(e);
		}
		byte[] mdBytes = md.digest();

		return bytesToString(mdBytes);
	}

}
