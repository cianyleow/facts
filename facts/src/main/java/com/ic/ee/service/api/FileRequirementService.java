package com.ic.ee.service.api;

import java.util.List;

import com.ic.ee.domain.common.file.FileRequirement;

public interface FileRequirementService {

	public List<FileRequirement> createFileRequirements(Integer assignmentId, List<FileRequirement> fileRequirements);

	public FileRequirement getFileRequirement(Integer fileRequirementId);
}
