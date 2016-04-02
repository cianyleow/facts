package com.ic.ee.core.jdbc.api;

import com.ic.ee.domain.common.file.FileRequirement;

public interface FileRequirementDAO {

	public Integer createFileRequirement(Integer assignmentId, FileRequirement fileRequirement);

}
