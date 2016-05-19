package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.UserAuthorityDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.UserAuthorityRowMapper;
import com.ic.ee.domain.user.auth.UserAuthority;

public class JdbcUserAuthorityDAO extends AbstractJdbcBaseDAO<UserAuthority, String> implements UserAuthorityDAO {

	public JdbcUserAuthorityDAO(DataSource dataSource) throws IOException {
		super(dataSource, new UserAuthorityRowMapper(), UserAuthority.class, "getUserAuthorities.sql");
	}

	@Override
	public List<UserAuthority> getUserAuthorities(String username) {
		SqlParameterSource paramSource = new MapSqlParameterSource("username", username);
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, getRowMapper());
	}

	@Override
	public MapSqlParameterSource getNewSqlParameterSource(UserAuthority object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("username", object.getUser().getUsername());
		paramSource.addValue("authority", object.getAuthority());
		return paramSource;
	}

	@Override
	public MapSqlParameterSource getUpdateSqlParameterSource(UserAuthority updateObject, UserAuthority existingObject) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("authority", updateObject.getAuthority() == null ? existingObject.getAuthority() : updateObject.getAuthority());
		return paramSource;
	}

	@Override
	public String extractId(KeyHolder keyHolder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId(UserAuthority object) {
		return object.getUser().getUsername();
	}

}
