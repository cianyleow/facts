package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.FileDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.FileRowMapper;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.course.assignment.submission.Submission;

public class JdbcFileDAO extends AbstractJdbcBaseDAO<File, Integer> implements FileDAO {

	public JdbcFileDAO(DataSource dataSource) throws IOException {
		super(dataSource, new FileRowMapper(), File.class, "severalFileForSubmission.sql",
				"severalFileForAssignment.sql");
	}

	@Override
	public List<File> getFiles(Submission submission) {
		SqlParameterSource paramSource = new MapSqlParameterSource("submissionId", submission.getSubmissionId());
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, getRowMapper());
	}

	@Override
	public List<File> getFiles(Assignment assignment) {
		SqlParameterSource paramSource = new MapSqlParameterSource("assignmentId", assignment.getAssignmentId());
		return getJdbcTemplate().query(getSqlStatements().get(1), paramSource, getRowMapper());
	}

	@Override
	public MapSqlParameterSource getSqlParameterSource(File object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("name", object.getName());
		paramSource.addValue("extension", object.getExtension());
		paramSource.addValue("hash", object.getHash());
		paramSource.addValue("location", object.getLocation());
		paramSource.addValue("size", object.getSize());
		paramSource.addValue("username", object.getOwner().getUserName());
		paramSource.addValue("contentType", object.getContentType());
		return paramSource;
	}

	@Override
	public Integer extractId(KeyHolder keyHolder) {
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer getId(File object) {
		return object.getFileId();
	}
}
