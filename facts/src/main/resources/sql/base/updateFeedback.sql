UPDATE feedback SET 
feedbackStatus = :feedbackStatus,
username = :username,
mark = :mark,
dueTime = :dueTime,
markReleased = :markReleased,
commentReleased = :commentReleased 
WHERE feedbackId = :id