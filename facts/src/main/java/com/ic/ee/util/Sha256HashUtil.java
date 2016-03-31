package com.ic.ee.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

}
