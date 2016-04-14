package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.FileDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.FileRowMapper;
import com.ic.ee.domain.common.file.File;

public class JdbcFileDAO extends AbstractJdbcBaseDAO<File, Integer> implements FileDAO {

	public JdbcFileDAO(DataSource dataSource) throws IOException {
		super(dataSource, new FileRowMapper(), File.class, "addDownloadLink.sql",
				"getFileFromLink.sql", "voidDownloadLink.sql",
				"createFile.sql", "getFilesFromSubmissionId.sql",
				"getFilesFromAssignment.sql");
	}

	@Override
	public Integer addDownloadLink(File file, String hash, String username) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("fileId", file.getFileId());
		paramSource.addValue("link", hash);
		paramSource.addValue("username", username);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(getSqlStatements().get(0), paramSource, keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public File getFileFromLink(String link) {
		SqlParameterSource paramSource = new MapSqlParameterSource("link", link);
		return getJdbcTemplate().queryForObject(getSqlStatements().get(1), paramSource, getRowMapper());
	}

	@Override
	public Integer voidDownloadLink(String link) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("link", link);
		return getJdbcTemplate().update(getSqlStatements().get(2), paramSource);
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
		getJdbcTemplate().update(getSqlStatements().get(3), paramSource, keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public List<File> getSubmissionFiles(Integer submissionId) {
		SqlParameterSource paramSource = new MapSqlParameterSource("submissionId", submissionId);
		return getJdbcTemplate().query(getSqlStatements().get(4), paramSource, getRowMapper());
	}

	@Override
	public List<File> getAssignmentFiles(Integer assignmentId) {
		SqlParameterSource paramSource = new MapSqlParameterSource("assignmentId", assignmentId);
		return getJdbcTemplate().query(getSqlStatements().get(5), paramSource, getRowMapper());
	}

	@Override
	public MapSqlParameterSource getSqlParameterSource(File object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("name", object.getName());
		paramSource.addValue("extension", object.getExtension());
		paramSource.addValue("hash", object.getHash());
		paramSource.addValue("location", object.getLocation());
		paramSource.addValue("size", object.getSize());
		paramSource.addValue("username", "" /*object.getUser().getUsername()*/);
		paramSource.addValue("contentType", object.getContentType());
		return paramSource;
	}

	@Override
	public Integer extractKey(KeyHolder keyHolder) {
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer getKey(File object) {
		return object.getFileId();
	}
}
