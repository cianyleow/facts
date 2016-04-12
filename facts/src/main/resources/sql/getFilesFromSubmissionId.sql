SELECT file.fileId, name, extension, hash, location, size, creationTime, contentType 
FROM file JOIN submission_file 
ON file.fileId = submission_file.fileId 
WHERE submission_file.submissionId = :submissionId;