SELECT notification.notificationId, title, content, link, notification_for.seen, creationTime  
FROM notification 
LEFT JOIN notification_for 
ON notification.notificationId = notification_for.notificationId 
WHERE notification.notificationId = :id