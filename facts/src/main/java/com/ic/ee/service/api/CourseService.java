package com.ic.ee.service.api;

import java.util.List;

import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.CourseDetails;

public interface CourseService {

	// Creating
	public Integer saveCourse(Course course);

	// Updating
	public Boolean updateCourse(Course course);

	// Deleting

	// Getting
	public List<CourseDetails> getAllCourseDetails();

	public CourseDetails getCourseDetails(Integer courseId) throws NoResultsReturnedException, TooManyResultsReturnedException;

	public Course getCourse(Integer courseId) throws NoResultsReturnedException, TooManyResultsReturnedException;

	public List<CourseDetails> getCourseDetailsByAcademicPeriod(Integer academicPeriodId);
}
