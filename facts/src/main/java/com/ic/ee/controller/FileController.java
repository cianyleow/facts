package com.ic.ee.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.core.web.exception.DownloadLinkDoesNotExistException;
import com.ic.ee.core.web.exception.DownloadLinkVoidFailedException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.service.api.FileService;

@RestController
public class FileController {

	@Autowired
	private FileService fileService;

	@RequestMapping(path = "/files/{fileId}/link", method = RequestMethod.GET)
	public Map<String, String> getFileLink(@PathVariable("fileId") Integer fileId, Principal user) throws NoResultsReturnedException, TooManyResultsReturnedException {
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("link", fileService.getDownloadLink(fileId, user.getName()));
		return hashMap;
	}

	@RequestMapping(path = "/files/{link}/download", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public FileSystemResource downloadAnonymousFile(@PathVariable("link") String link, HttpServletResponse response) throws DownloadLinkDoesNotExistException, DownloadLinkVoidFailedException {
		File file = fileService.getFile(link);
//		response.setContentType(file.getContentType());
		response.setHeader("Content-Disposition", "attachment; filename=" + file.getName() + "." + file.getExtension());
		return new FileSystemResource("C:/Temp/finalcopywithbleed_Part10.pdf");
	}
}
