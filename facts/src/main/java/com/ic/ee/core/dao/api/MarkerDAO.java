package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.user.marker.Marker;

public interface MarkerDAO extends BaseDAO<Marker, String> {

	public List<Marker> getMarkers(Course course);

	public List<Marker> getMarkers(Assignment assignment);

}
