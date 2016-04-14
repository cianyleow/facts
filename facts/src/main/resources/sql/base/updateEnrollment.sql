UPDATE enrollment SET
username = :username,
courseId = :courseId,
enrollmentLevel = :enrollmentLevel
WHERE enrollmentId = :id