package com.ic.ee.core.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.ic.ee.core.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.jdbc.api.AuthUserDAO;
import com.ic.ee.core.jdbc.rowmapper.AuthUserRowMapper;
import com.ic.ee.domain.user.auth.AuthUser;

public class JdbcAuthUserDAO extends AbstractJdbcBaseDAO implements AuthUserDAO {
	Logger logger = Logger.getLogger(this.getClass());

	public JdbcAuthUserDAO(DataSource dataSource) throws IOException {
		super(dataSource, "getAuthUsers.sql");
	}

	@Override
	public List<AuthUser> getAuthUsers(List<String> usernames) {
		SqlParameterSource paramSource = new MapSqlParameterSource("usernames", usernames);
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, new AuthUserRowMapper());
	}
}
