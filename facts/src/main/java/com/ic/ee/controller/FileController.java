package com.ic.ee.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.service.api.FileService;

@RestController
public class FileController {

	@Autowired
	private FileService fileService;

	@RequestMapping(path = "/files/{fileId}/link", method = RequestMethod.GET)
	public String getFileLink(@PathVariable("fileId") Integer fileId, Principal user) throws NoResultsReturnedException, TooManyResultsReturnedException {
		return fileService.getDownloadLink(fileId, user.getName());
	}

}
