SELECT course.courseId, course.name, course.shortName, course.description, 
academic_period.academicPeriodId, academic_period.name, academic_period.shortName, academic_period.startTime, academic_period.endTime 
FROM course JOIN academic_period ON course.academicPeriodId = academic_period.academicPeriodId  
JOIN enrollment ON course.courseId = enrollment.courseId 
WHERE enrollment.username = :username