package com.ic.ee.domain.course.dao.api;

import java.util.Set;

import com.ic.ee.domain.common.AcademicPeriod;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.CourseDetails;

public interface CourseDAO {

	public Course saveCourse(Course newCourse);

	public Course getCourse(Integer courseId);

	public CourseDetails getCourseDetails(Integer courseId);

	public Course getCurrentYearCourses(AcademicPeriod academicPeriod);

	public Set<CourseDetails> getAllCourses();
}
