UPDATE feedback SET 
commentStatus = :commentStatus,
markStatus = :markStatus,
username = :username,
mark = :mark,
dueTime = :dueTime 
WHERE feedbackId = :id