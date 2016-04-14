package com.ic.ee.core.dao.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.api.FileRequirementDAO;
import com.ic.ee.core.dao.rowmapper.FileRequirementRowMapper;
import com.ic.ee.domain.common.file.FileRequirement;

public class JdbcFileRequirementDAO extends AbstractJdbcBaseDAO<FileRequirement, Integer> implements FileRequirementDAO {

	public JdbcFileRequirementDAO(DataSource dataSource) throws IOException {
		super(dataSource, new FileRequirementRowMapper(), FileRequirement.class, "createFileRequirement.sql", "getFileRequirementsByIds.sql",
				"getFileRequirementsByAssignment.sql");
	}

	@Override
	public Integer createFileRequirement(Integer assignmentId, FileRequirement fileRequirement) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("assignmentId", assignmentId);
		paramSource.addValue("fileName", fileRequirement.getFileName());
		paramSource.addValue("maxFileSize", fileRequirement.getMaxFileSize());
		paramSource.addValue("allowedExtension", fileRequirement.getAllowedExtension());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(getSqlStatements().get(0), paramSource, keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public List<FileRequirement> getFileRequirements(List<Integer> fileRequirementIds) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("fileRequirementIds", fileRequirementIds);
		return getJdbcTemplate().query(getSqlStatements().get(1), paramSource, getRowMapper());
	}

	 @Override
	 public List<FileRequirement> getFileRequirements(Integer assignmentId) {
		 SqlParameterSource paramSource = new MapSqlParameterSource("assignmentId", assignmentId);
		 return getJdbcTemplate().query(getSqlStatements().get(2), paramSource, getRowMapper());
	 }

}
