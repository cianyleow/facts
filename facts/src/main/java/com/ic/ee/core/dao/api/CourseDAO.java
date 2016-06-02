package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.marker.Marker;

public interface CourseDAO extends BaseDAO<Course, Integer> {

	public List<Course> getCourses();

	public List<Course> getEnrolled(String username);

	public List<Course> getMarked(String username);

	public List<Course> getOwned(String username);

	public void addMarker(Course course, Marker marker);
}
