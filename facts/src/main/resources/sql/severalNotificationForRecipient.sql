SELECT notificationId, title, content, link, read, creationTime, username 
FROM notification 
WHERE username = :username