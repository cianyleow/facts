UPDATE feedback SET
submissionId = :submissionId,
commentStatus = :commentStatus,
markStatus = :markStatus,
username = :username
WHERE feedbackId = :id