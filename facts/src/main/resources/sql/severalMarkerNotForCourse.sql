SELECT user.username, email, firstName, lastName, title 
FROM user JOIN user_title ON user.username = user_title.username 
WHERE user.username NOT IN (SELECT username FROM marker_for WHERE courseId = :courseId)