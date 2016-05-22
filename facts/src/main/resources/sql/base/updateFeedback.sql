UPDATE feedback SET 
commentStatus = :commentStatus,
markStatus = :markStatus,
username = :username,
mark = :mark,
dueTime = :dueTime,
markReleased = :markReleased,
commentReleased = :commentReleased 
WHERE feedbackId = :id