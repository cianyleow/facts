SELECT fileRequirementId, fileName, maxFileSize, allowedExtension FROM file_requirement WHERE fileRequirementId IN (:fileRequirementIds)