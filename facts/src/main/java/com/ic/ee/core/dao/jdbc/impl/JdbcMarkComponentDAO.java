package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.MarkComponentDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.MarkComponentRowMapper;
import com.ic.ee.domain.common.feedback.mark.MarkComponent;

public class JdbcMarkComponentDAO extends AbstractJdbcBaseDAO<MarkComponent, Integer> implements MarkComponentDAO {

	public JdbcMarkComponentDAO(DataSource dataSource) throws IOException {
		super(dataSource, new MarkComponentRowMapper(), MarkComponent.class, "severalMarkComponentForAssignment.sql");
	}

	@Override
	public List<MarkComponent> getMarkComponents(Integer assignmentId) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("assignmentId", assignmentId);
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, getRowMapper());
	}

	@Override
	public MapSqlParameterSource getSqlParameterSource(MarkComponent object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("assignmentId", object.getAssignment().getAssignmentId());
		paramSource.addValue("maxMark", object.getMaxMark());
		paramSource.addValue("name", object.getName());
		paramSource.addValue("description", object.getDescription());
		return paramSource;
	}

	@Override
	public Integer extractId(KeyHolder keyHolder) {
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer getId(MarkComponent object) {
		return object.getMarkComponentId();
	}


}
