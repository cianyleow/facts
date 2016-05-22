INSERT INTO feedback (
submissionId,
username,
commentStatus,
markStatus,
mark,
dueTime,
commentReleased,
markReleased
) VALUES (
:submissionId, 
:username,
:commentStatus,
:markStatus,
:mark,
:dueTime,
:commentReleased,
:markReleased
);
