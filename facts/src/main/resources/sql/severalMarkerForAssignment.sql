SELECT user.username, email, firstName, lastName, title 
FROM user 
JOIN user_title ON user.username = user_title.username 
JOIN marker_for ON user.username = marker_for.username 
JOIN assignment ON marker_for.courseId = assignment.courseId 
WHERE assignment.assignmentId = :assignmentId