SELECT file.fileId, name, extension, hash, location, size, creationTime, contentType 
FROM file JOIN assignment_file 
ON file.fileId = assignment_file.fileId 
WHERE assignment_file.assignmentId = :assignmentId;