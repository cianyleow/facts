SELECT notification.notificationId, title, content, link, true AS `notification_for.seen`, creationTime   
FROM notification  
WHERE notification.notificationId = :id