SELECT courseId, name, shortName, description, academicPeriodId FROM course WHERE courseId IN (:courseIds)