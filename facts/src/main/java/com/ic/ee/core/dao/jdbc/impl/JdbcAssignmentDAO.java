package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.AssignmentDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.AssignmentRowMapper;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.assignment.Assignment;

public class JdbcAssignmentDAO extends AbstractJdbcBaseDAO<Assignment, Integer> implements AssignmentDAO {

	public JdbcAssignmentDAO(DataSource dataSource) throws IOException {
		super(dataSource, new AssignmentRowMapper(), Assignment.class, "severalAssignmentForCourse.sql",
				"createAssignmentFile.sql");
	}

	@Override
	public List<Assignment> getAssignments(Course course) {
		SqlParameterSource paramSource = new MapSqlParameterSource("courseId", course.getCourseId());
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, getRowMapper());
	}

	@Override
	public void createAssignmentFile(Integer assignmentId, File file) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("assignmentId", assignmentId);
		paramSource.addValue("fileId", file.getFileId());
		getJdbcTemplate().update(getSqlStatements().get(1), paramSource);
	}

	@Override
	public MapSqlParameterSource getNewSqlParameterSource(Assignment object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("courseId", object.getCourse().getCourseId());
		paramSource.addValue("name", object.getName());
		paramSource.addValue("description", object.getDescription());
		paramSource.addValue("dueTime", object.getDueTime());
		paramSource.addValue("openTime", object.getOpenTime());
		return paramSource;
	}

	@Override
	public MapSqlParameterSource getUpdateSqlParameterSource(Assignment updateObject, Assignment existingObject) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("name", updateObject.getName() == null ? existingObject.getName() : updateObject.getName());
		paramSource.addValue("description", updateObject.getDescription() == null ? existingObject.getDescription() : updateObject.getDescription());
		paramSource.addValue("dueTime", updateObject.getDueTime() == null ? existingObject.getDueTime() : updateObject.getDueTime());
		paramSource.addValue("openTime", updateObject.getOpenTime() == null ? existingObject.getOpenTime() : updateObject.getOpenTime());
		return paramSource;
	}

	@Override
	public Integer extractId(KeyHolder keyHolder) {
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer getId(Assignment object) {
		return object.getAssignmentId();
	}
}
