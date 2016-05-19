package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.MarkerDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.MarkerRowMapper;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.user.marker.Marker;

public class JdbcMarkerDAO extends AbstractJdbcBaseDAO<Marker, String> implements MarkerDAO {

	public JdbcMarkerDAO(DataSource dataSource) throws IOException {
		super(dataSource, new MarkerRowMapper(), Marker.class, "severalMarkersForCourse.sql");
	}

	@Override
	public List<Marker> getMarkers(Course course) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("courseId", course.getCourseId());
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, getRowMapper());
	}

	@Override
	public MapSqlParameterSource getNewSqlParameterSource(Marker object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("username", object.getUserName());
		paramSource.addValue("title", object.getTitle());
		return paramSource;
	}

	@Override
	public MapSqlParameterSource getUpdateSqlParameterSource(Marker updateObject, Marker existingObject) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("title", updateObject.getTitle() == null ? existingObject.getTitle() : updateObject.getTitle());
		return paramSource;
	}

	@Override
	public String extractId(KeyHolder keyHolder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId(Marker object) {
		return object.getUserName();
	}
}
