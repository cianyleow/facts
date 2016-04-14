UPDATE assignment SET
courseId = :courseId,
name = :name,
description = :description,
dueTime = :dueTime,
openTime = :openTime
WHERE assignmentId = :id