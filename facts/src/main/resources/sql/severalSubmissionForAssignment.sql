SELECT submissionId, comment, creationTime, assignmentId, username, submissionStatus, version FROM (
	SELECT MAX(submissionId) AS maxSubmissionId, COUNT(submissionId) AS version 
	FROM submission 
	WHERE assignmentId = :assignmentId 
	GROUP BY assignmentId, username
) AS m INNER JOIN submission AS s 
ON s.submissionId = m.maxSubmissionId