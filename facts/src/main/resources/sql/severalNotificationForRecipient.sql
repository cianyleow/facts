SELECT notification.notificationId, title, content, link, notification_for.seen, creationTime 
FROM notification JOIN notification_for ON notification.notificationId = notification_for.notificationId 
WHERE notification_for.username = :username