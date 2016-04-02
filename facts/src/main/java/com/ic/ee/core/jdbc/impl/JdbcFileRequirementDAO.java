package com.ic.ee.core.jdbc.impl;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.jdbc.api.FileRequirementDAO;
import com.ic.ee.domain.common.file.FileRequirement;

public class JdbcFileRequirementDAO extends AbstractJdbcBaseDAO implements FileRequirementDAO {

	public JdbcFileRequirementDAO(DataSource dataSource) throws IOException {
		super(dataSource, "createFileRequirement.sql");
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

}
