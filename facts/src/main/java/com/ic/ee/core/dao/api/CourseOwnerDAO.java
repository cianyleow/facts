package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.courseowner.CourseOwner;

public interface CourseOwnerDAO extends BaseDAO<CourseOwner, String> {

	public List<CourseOwner> getCourseOwners(Course course);

}
