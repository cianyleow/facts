package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.DownloadLinkDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.DownloadLinkRowMapper;
import com.ic.ee.domain.common.file.DownloadLink;

public class JdbcDownloadLinkDAO extends AbstractJdbcBaseDAO<DownloadLink, Integer> implements DownloadLinkDAO {

	public JdbcDownloadLinkDAO(DataSource dataSource) throws IOException {
		super(dataSource, new DownloadLinkRowMapper(), DownloadLink.class, "oneDownloadLinkByLink.sql");
	}

	@Override
	public DownloadLink getDownloadLink(String link) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("link", link);
		return getJdbcTemplate().queryForObject(getSqlStatements().get(0), paramSource, getRowMapper());
	}

	@Override
	public MapSqlParameterSource getNewSqlParameterSource(DownloadLink object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("fileId", object.getFile().getFileId());
		paramSource.addValue("link", object.getLink());
		paramSource.addValue("username", object.getUser().getUserName());
		paramSource.addValue("used", object.isUsed());
		return paramSource;
	}

	@Override
	public MapSqlParameterSource getUpdateSqlParameterSource(DownloadLink updateObject, DownloadLink existingObject) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("used", updateObject.isUsed() == null ? existingObject.isUsed() : updateObject.isUsed());
		return paramSource;
	}

	@Override
	public Integer extractId(KeyHolder keyHolder) {
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer getId(DownloadLink object) {
		return object.getDownloadLinkId();
	}

}
