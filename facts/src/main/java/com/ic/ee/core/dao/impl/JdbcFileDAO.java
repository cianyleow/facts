package com.ic.ee.core.dao.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.api.FileDAO;
import com.ic.ee.core.dao.rowmapper.FileRowMapper;
import com.ic.ee.domain.common.file.File;

public class JdbcFileDAO extends AbstractJdbcBaseDAO implements FileDAO {

	public JdbcFileDAO(DataSource dataSource) throws IOException {
		super(dataSource, "getFiles.sql", "addDownloadLink.sql",
				"getFileFromLink.sql", "voidDownloadLink.sql",
				"createFile.sql", "getFilesFromSubmissionId.sql",
				"getFilesFromAssignment.sql");
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

	@Override
	public List<File> getFiles(String link) {
		SqlParameterSource paramSource = new MapSqlParameterSource("link", link);
		return getJdbcTemplate().query(getSqlStatements().get(2), paramSource, new FileRowMapper());
	}

	@Override
	public Integer voidDownloadLink(String link) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("link", link);
		return getJdbcTemplate().update(getSqlStatements().get(3), paramSource);
	}

	@Override
	public Integer createFile(String username, File file) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("name", file.getName());
		paramSource.addValue("extension", file.getExtension());
		paramSource.addValue("hash", file.getHash());
		paramSource.addValue("location", file.getLocation());
		paramSource.addValue("size", file.getSize());
		paramSource.addValue("username", username);
		paramSource.addValue("contentType", file.getContentType());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(getSqlStatements().get(4), paramSource, keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public List<File> getSubmissionFiles(Integer submissionId) {
		SqlParameterSource paramSource = new MapSqlParameterSource("submissionId", submissionId);
		return getJdbcTemplate().query(getSqlStatements().get(5), paramSource, new FileRowMapper());
	}

	@Override
	public List<File> getAssignmentFiles(Integer assignmentId) {
		SqlParameterSource paramSource = new MapSqlParameterSource("assignmentId", assignmentId);
		return getJdbcTemplate().query(getSqlStatements().get(6), paramSource, new FileRowMapper());
	}
}
