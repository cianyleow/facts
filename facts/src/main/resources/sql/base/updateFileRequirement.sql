UPDATE file_requirement SET
fileName = :fileName,
maxFileSize = :maxFileSize,
allowedExtension = :allowedExtension
WHERE fileRequirementId = :id