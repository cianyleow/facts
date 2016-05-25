SELECT submissionId, comment, creationTime, assignmentId, username, submissionStatus, version, credit FROM (
	SELECT MAX(submissionId) AS maxSubmissionId, COUNT(submissionId) AS version, 1 AS credit 
	FROM submission 
	WHERE assignmentId = :assignmentId 
	AND submissionStatus <> 'LATE'
	GROUP BY assignmentId, username
) AS m INNER JOIN submission AS s 
ON s.submissionId = m.maxSubmissionId