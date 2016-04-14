package com.ic.ee.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ic.ee.core.dao.api.FileRequirementDAO;
import com.ic.ee.domain.common.file.FileRequirement;
import com.ic.ee.service.api.FileRequirementService;

public class SimpleFileRequirementService implements FileRequirementService {

	private final FileRequirementDAO fileRequirementDAO;

	public SimpleFileRequirementService(FileRequirementDAO fileRequirementDAO) {
		this.fileRequirementDAO = fileRequirementDAO;
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
		return fileRequirementDAO.create(fileRequirement);
	}

	@Override
	public FileRequirement getFileRequirement(Integer fileRequirementId) {
		return fileRequirementDAO.one(fileRequirementId);
	}

}
