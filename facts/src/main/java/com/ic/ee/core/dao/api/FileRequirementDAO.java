package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.domain.common.file.FileRequirement;

public interface FileRequirementDAO {

	public Integer createFileRequirement(Integer assignmentId, FileRequirement fileRequirement);

	public List<FileRequirement> getFileRequirements(List<Integer> fileRequirementIds);

}
