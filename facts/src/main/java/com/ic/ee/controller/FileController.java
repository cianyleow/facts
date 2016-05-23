package com.ic.ee.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.ic.ee.core.web.exception.DownloadLinkExpiredException;
import com.ic.ee.core.web.exception.DownloadLinkUsedException;
import com.ic.ee.domain.Views;
import com.ic.ee.domain.common.file.DownloadLink;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.service.api.FileService;
import com.ic.ee.util.FileUtils;

@RestController
public class FileController {

	@Autowired
	private FileService fileService;

	@Autowired
	private FileUtils fileUtils;

	@JsonView(Views.Public.class)
	@RequestMapping(path = "/files/{fileId}/link", method = RequestMethod.GET)
	public DownloadLink getFileLink(@PathVariable("fileId") Integer fileId, Principal user) {
		return fileService.createDownloadLink(fileId, user.getName());
	}

	@JsonView(Views.Public.class)
	@RequestMapping(path = "/files/{link}/download", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public FileSystemResource downloadAnonymousFile(@PathVariable("link") String link, HttpServletResponse response) throws DownloadLinkUsedException, DownloadLinkExpiredException {
		DownloadLink downloadLink = fileService.getDownloadLink(link);
		File file = downloadLink.getFile();
		response.setHeader("Content-Disposition", "attachment; filename=" + file.getName() + "." + file.getExtension());
		return new FileSystemResource(fileUtils.getFileLocation(file.getLocation()));
	}
}
