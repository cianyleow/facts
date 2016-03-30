SELECT course.courseId, course.name, course.shortName, course.description, academic_period.academicPeriodId, academic_period.name, academic_period.shortName, academic_period.startTime, academic_period.endTime FROM course JOIN academic_period WHERE course.academicPeriodId = academic_period.academicPeriodId AND course.courseID IN (:courseIds)