UPDATE feedback SET
commentStatus = :commentStatus,
markStatus = :markStatus,
username = :username
WHERE feedbackId = :id