package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.student.Student;

public interface StudentDAO extends BaseDAO<Student, String>{

	public List<Student> getStudents(Course course);

}
