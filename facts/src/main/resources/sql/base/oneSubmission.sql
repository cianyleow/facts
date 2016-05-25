SELECT submissionId, comment, submissionStatus, creationTime, assignmentId, username, (
	SELECT COUNT(submissionId) 
	FROM submission 
	WHERE creationTime <= (
		SELECT creationTime FROM submission WHERE submissionId = :id
	) AND assignmentId = (
		SELECT assignmentId FROM submission WHERE submissionId = :id
	)
) AS version, (
	SELECT(IF(submissionStatus <> 'LATE' AND (
		SELECT(IF(COUNT(submissionId) = 0, 1, 0))
		FROM submission 
		WHERE creationTime > (
			SELECT creationTime FROM submission WHERE submissionId = :id
		) AND assignmentId = (
			SELECT assignmentId FROM submission WHERE submissionId = :id
		) AND submissionStatus <> 'LATE'
	), 'true', 'false'))
) AS credit 
FROM submission WHERE submissionId = :id;