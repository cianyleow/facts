SELECT enrollment.enrollmentId, enrollment.username, enrollment.courseId, enrollment.enrollmentLevel, enrollment.updateTime,  
course.courseId, course.shortName, course.name, course.description, course.academicPeriodId 
FROM enrollment JOIN course ON enrollment.courseId = course.courseId 
WHERE enrollment.enrollmentId IN (:ids)