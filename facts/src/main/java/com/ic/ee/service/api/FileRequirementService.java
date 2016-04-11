package com.ic.ee.service.api;

import java.util.List;

import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.file.FileRequirement;

public interface FileRequirementService {

	public List<FileRequirement> createFileRequirements(Integer assignmentId, List<FileRequirement> fileRequirements);

	public FileRequirement getFileRequirement(Integer fileRequirementId) throws NoResultsReturnedException, TooManyResultsReturnedException;
}
