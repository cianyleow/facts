SELECT assignmentId, courseId, name, description, creationTime, dueTime, openTime FROM assignment WHERE courseId = :courseId