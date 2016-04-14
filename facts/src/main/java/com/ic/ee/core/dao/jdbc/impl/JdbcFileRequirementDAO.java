package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.FileRequirementDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.FileRequirementRowMapper;
import com.ic.ee.domain.common.file.FileRequirement;

public class JdbcFileRequirementDAO extends AbstractJdbcBaseDAO<FileRequirement, Integer> implements FileRequirementDAO {

	public JdbcFileRequirementDAO(DataSource dataSource) throws IOException {
		super(dataSource, new FileRequirementRowMapper(), FileRequirement.class,
				"getFileRequirementsByAssignment.sql");
	}

	@Override
	public List<FileRequirement> getFileRequirements(Integer assignmentId) {
		SqlParameterSource paramSource = new MapSqlParameterSource("assignmentId", assignmentId);
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, getRowMapper());
	}

	@Override
	public MapSqlParameterSource getSqlParameterSource(FileRequirement object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("assignmentId", 0 /*object.getAssignment().getAssigment()*/);
		paramSource.addValue("fileName", object.getFileName());
		paramSource.addValue("maxFileSize", object.getMaxFileSize());
		paramSource.addValue("allowedExtension", object.getAllowedExtension());
		return paramSource;
	}

	@Override
	public Integer extractKey(KeyHolder keyHolder) {
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer getKey(FileRequirement object) {
		return object.getFileRequirementId();
	}
}
