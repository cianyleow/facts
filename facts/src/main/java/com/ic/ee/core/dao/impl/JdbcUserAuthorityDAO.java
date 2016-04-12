package com.ic.ee.core.dao.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.ic.ee.core.dao.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.api.UserAuthorityDAO;
import com.ic.ee.core.dao.rowmapper.UserAuthorityRowMapper;
import com.ic.ee.domain.user.auth.UserAuthority;

public class JdbcUserAuthorityDAO extends AbstractJdbcBaseDAO implements UserAuthorityDAO {

	public JdbcUserAuthorityDAO(DataSource dataSource) throws IOException {
		super(dataSource, "getUserAuthorities.sql");
	}

	@Override
	public List<UserAuthority> getUserAuthorities(String username) {
		SqlParameterSource paramSource = new MapSqlParameterSource("username", username);
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, new UserAuthorityRowMapper());
	}

}
