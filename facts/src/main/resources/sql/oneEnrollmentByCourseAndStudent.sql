SELECT enrollment.enrollmentId, enrollment.username, enrollment.courseId, enrollment.enrollmentLevel, enrollment.updateTime 
FROM enrollment 
WHERE enrollment.username = :username 
AND enrollment.courseId = :courseId