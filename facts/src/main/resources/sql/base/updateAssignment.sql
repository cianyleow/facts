UPDATE assignment SET
name = :name,
description = :description,
dueTime = :dueTime,
openTime = :openTime
WHERE assignmentId = :id