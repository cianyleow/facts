package com.ic.ee.service.api;

import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.course.Course;

public interface CourseService {

	public Course getCourse(Integer courseId) throws NoResultsReturnedException, TooManyResultsReturnedException;
}
