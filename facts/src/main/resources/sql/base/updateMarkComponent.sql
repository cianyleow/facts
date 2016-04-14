UPDATE mark_component SET
assignmentId = :assignmentId,
maxMark = :maxMark,
name = :name,
description = :description
WHERE markComponentId = :id