UPDATE course SET
name = :name,
shortName = :shortName,
description = :description,
academicPeriodId = :acdemicPeriodId
WHERE courseId = :id