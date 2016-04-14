package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.common.file.FileRequirement;

public interface FileRequirementDAO extends BaseDAO<FileRequirement, Integer> {

	public FileRequirement getFileRequirement(Integer fileRequirementId);

	public Integer createFileRequirement(Integer assignmentId, FileRequirement fileRequirement);

	public List<FileRequirement> getFileRequirements(Integer assignmentId);

}
