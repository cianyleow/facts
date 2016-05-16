SELECT submissionId, comment, submissionStatus, creationTime, assignmentId, username, (
	SELECT COUNT(submissionId) 
	FROM submission 
	WHERE creationTime <= (
		SELECT creationTime FROM submission WHERE submissionId = :id
	) AND assignmentId = (
		SELECT assignmentId FROM submission WHERE submissionId = :id
	)
) AS version 
FROM submission WHERE submissionId = :id;

