package com.ic.ee.core.jdbc.impl;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.jdbc.api.MarkComponentDAO;
import com.ic.ee.domain.common.feedback.mark.MarkComponent;

public class JdbcMarkComponentDAO extends AbstractJdbcBaseDAO implements MarkComponentDAO {

	public JdbcMarkComponentDAO(DataSource dataSource) throws IOException {
		super(dataSource, "createMarkComponent.sql");
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
}
