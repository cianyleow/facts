SELECT course.courseId, course.name, course.shortName, course.description FROM course JOIN marker_for WHERE course.courseId = owns.courseId AND owns.username = :username