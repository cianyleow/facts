package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.course.Course;

public interface CourseDAO extends BaseDAO<Course, Integer> {

	public List<Course> getCourses();

	public List<Course> getCourses(String username);
}
