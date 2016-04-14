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
	public MapSqlParameterSource getSqlParameterSource(UserAuthority object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String extractKey(KeyHolder keyHolder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKey(UserAuthority object) {
		// TODO Auto-generated method stub
		return null;
	}

}
