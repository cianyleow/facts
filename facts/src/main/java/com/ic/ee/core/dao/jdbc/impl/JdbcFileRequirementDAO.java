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
				"severalFileRequirementForAssignment.sql");
	}

	@Override
	public List<FileRequirement> getFileRequirements(Integer assignmentId) {
		SqlParameterSource paramSource = new MapSqlParameterSource("assignmentId", assignmentId);
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, getRowMapper());
	}

	@Override
	public MapSqlParameterSource getNewSqlParameterSource(FileRequirement object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("assignmentId", object.getAssignment().getAssignmentId());
		paramSource.addValue("fileName", object.getFileName());
		paramSource.addValue("maxFileSize", object.getMaxFileSize());
		paramSource.addValue("allowedExtension", object.getAllowedExtension());
		return paramSource;
	}

	@Override
	public MapSqlParameterSource getUpdateSqlParameterSource(FileRequirement updateObject, FileRequirement existingObject) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("fileName", updateObject.getFileName() == null ? existingObject.getFileName() : updateObject.getFileName());
		paramSource.addValue("maxFileSize", updateObject.getMaxFileSize() == null ? existingObject.getMaxFileSize() : updateObject.getMaxFileSize());
		paramSource.addValue("allowedExtension", updateObject.getAllowedExtension() == null ? existingObject.getAllowedExtension() : updateObject.getAllowedExtension());
		return paramSource;
	}

	@Override
	public Integer extractId(KeyHolder keyHolder) {
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer getId(FileRequirement object) {
		return object.getFileRequirementId();
	}
}
