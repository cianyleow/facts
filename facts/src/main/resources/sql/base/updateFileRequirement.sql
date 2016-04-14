UPDATE file_requirement SET
assignmentId = :assignmentId,
fileName = :fileName,
maxFileSize = :maxFileSize,
allowedExtension = :allowedExtension
WHERE fileRequirmentId = :id