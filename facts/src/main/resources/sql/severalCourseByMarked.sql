SELECT course.courseId, course.name, course.shortName, course.description, 
academic_period.academicPeriodId, academic_period.name, academic_period.shortName, academic_period.startTime, academic_period.endTime 
FROM course JOIN academic_period ON course.academicPeriodId = academic_period.academicPeriodId  
JOIN marker_for ON course.courseId = owns.courseId 
WHERE owns.username = :username