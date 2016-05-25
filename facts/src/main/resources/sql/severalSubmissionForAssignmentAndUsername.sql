SELECT @row_number:=@row_number+1 AS version, 
0 AS credit, 
submissionId, 
comment, 
submissionStatus, 
creationTime, 
assignmentId, 
username 
FROM submission, 
(SELECT @row_number:=0) r 
WHERE assignmentId = :assignmentId 
AND username = :username 
ORDER BY creationTime ASC