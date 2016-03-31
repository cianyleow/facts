package com.ic.ee.core.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.jdbc.api.FileDAO;
import com.ic.ee.core.jdbc.rowmapper.FileRowMapper;
import com.ic.ee.domain.common.file.File;

public class JdbcFileDAO extends AbstractJdbcBaseDAO implements FileDAO {

	public JdbcFileDAO(DataSource dataSource) throws IOException {
		super(dataSource, "getFiles.sql", "addDownloadLink.sql");
	}

	@Override
	public List<File> getFiles(List<Integer> fileIds) {
		SqlParameterSource paramSource = new MapSqlParameterSource("fileIds", fileIds);
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, new FileRowMapper());
	}

	@Override
	public Integer addDownloadLink(File file, String hash, String username) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("fileId", file.getFileId());
		paramSource.addValue("link", hash);
		paramSource.addValue("username", username);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(getSqlStatements().get(1), paramSource, keyHolder);
		return keyHolder.getKey().intValue();
	}
}
