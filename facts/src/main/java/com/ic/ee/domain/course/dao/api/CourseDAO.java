package com.ic.ee.domain.course.dao.api;

import com.ic.ee.domain.common.AcademicPeriod;
import com.ic.ee.domain.course.Course;

public interface CourseDAO {

	public Course saveCourse(Course newCourse);

	public Course getCourse(Integer courseId);

	public Course getCurrentYearCourses(AcademicPeriod academicPeriod);

	public Course getAllCourses();
}
