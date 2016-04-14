package com.ic.ee.core.dao.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.api.MarkComponentDAO;
import com.ic.ee.core.dao.rowmapper.MarkComponentRowMapper;
import com.ic.ee.domain.common.feedback.mark.MarkComponent;

public class JdbcMarkComponentDAO extends AbstractJdbcBaseDAO<MarkComponent, Integer> implements MarkComponentDAO {

	public JdbcMarkComponentDAO(DataSource dataSource) throws IOException {
		super(dataSource, new MarkComponentRowMapper(), MarkComponent.class, "createMarkComponent.sql", "getMarkComponent.sql", "getMarkComponentsByAssignment.sql");
	}

	@Override
	public Integer createMarkComponent(Integer assignmentId, MarkComponent markComponent) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("assignmentId", assignmentId);
		paramSource.addValue("maxMark", markComponent.getMaxMark());
		paramSource.addValue("name", markComponent.getName());
		paramSource.addValue("description", markComponent.getDescription());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(getSqlStatements().get(0), paramSource, keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public MarkComponent getMarkComponent(Integer markComponentId) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("markComponentId", markComponentId);
		return getJdbcTemplate().queryForObject(getSqlStatements().get(1), paramSource, getRowMapper());
	}

	@Override
	public List<MarkComponent> getMarkComponents(Integer assignmentId) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("assignmentId", assignmentId);
		return getJdbcTemplate().query(getSqlStatements().get(2), paramSource, getRowMapper());
	}


}
