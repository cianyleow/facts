package com.ic.ee.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ic.ee.core.jdbc.api.FileRequirementDAO;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.file.FileRequirement;
import com.ic.ee.service.api.FileRequirementService;
import com.ic.ee.util.ElementExtractor;

public class SimpleFileRequirementService implements FileRequirementService {

	private final FileRequirementDAO fileRequirementDAO;

	public SimpleFileRequirementService(FileRequirementDAO filerequirementDAO) {
		this.fileRequirementDAO = filerequirementDAO;
	}

	@Override
	public List<FileRequirement> createFileRequirements(Integer assignmentId, List<FileRequirement> fileRequirements) {
		List<FileRequirement> createdFileRequirements = new ArrayList<FileRequirement>();
		for(FileRequirement fileRequirement : fileRequirements) {
			createdFileRequirements.add(createFileRequirement(assignmentId, fileRequirement));
		}
		return createdFileRequirements;
	}

	public FileRequirement createFileRequirement(Integer assignmentId, FileRequirement fileRequirement) {
		Integer fileRequirementId = fileRequirementDAO.createFileRequirement(assignmentId, fileRequirement);
		fileRequirement.setFileRequirementId(fileRequirementId);
		return fileRequirement;
	}

	@Override
	public FileRequirement getFileRequirement(Integer fileRequirementId) throws NoResultsReturnedException, TooManyResultsReturnedException {
		List<FileRequirement> fileRequirements = fileRequirementDAO.getFileRequirements(Collections.singletonList(fileRequirementId));
		return ElementExtractor.extractOne(fileRequirements);
	}

}
