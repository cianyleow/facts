UPDATE feedback SET 
commentStatus = :commentStatus,
markStatus = :markStatus,
username = :username,
mark = :mark 
WHERE feedbackId = :id