INSERT INTO notification_for (
notificationId, 
username
) 
SELECT :notificationId, username 
FROM enrollment 
WHERE courseId = :courseId