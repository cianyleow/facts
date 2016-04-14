package com.ic.ee.core.dao.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.common.file.FileRequirement;

public class FileRequirementRowMapper implements RowMapper<FileRequirement> {

	@Override
	public FileRequirement mapRow(ResultSet rs, int rowNum) throws SQLException {
		FileRequirement fr = new FileRequirement(rs.getInt("fileRequirementId"));
		fr.setFileName(rs.getString("fileName"));
		fr.setAllowedExtension(rs.getString("allowedExtension"));
		fr.setMaxFileSize(rs.getInt("maxFileSize"));
		return fr;
	}

}
