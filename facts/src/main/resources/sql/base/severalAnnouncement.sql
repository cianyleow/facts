SELECT announcementId, courseId, content, link, creationTime, username FROM announcement WHERE announcementId IN (:ids)