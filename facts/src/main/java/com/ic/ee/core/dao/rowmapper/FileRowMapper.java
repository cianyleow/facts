package com.ic.ee.core.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.common.file.File;

public class FileRowMapper implements RowMapper<File> {

	@Override
	public File mapRow(ResultSet rs, int rowNum) throws SQLException {
		File file = new File();
		file.setFileId(rs.getInt("fileId"));
		file.setName(rs.getString("name"));
		file.setExtension(rs.getString("extension"));
		file.setContentType(rs.getString("contentType"));
		file.setHash(rs.getString("hash"));
		file.setLocation(rs.getString("location"));
		file.setSize(rs.getLong("size"));
		file.setCreationTime(rs.getDate("creationTime"));
		return file;
	}

}
