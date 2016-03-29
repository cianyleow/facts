package com.ic.ee.core.jdbc.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.ic.ee.core.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.jdbc.api.UserDAO;
import com.ic.ee.core.jdbc.rowmapper.UserRowMapper;
import com.ic.ee.domain.user.User;

public class JdbcUserDAO extends AbstractJdbcBaseDAO implements UserDAO {

	public JdbcUserDAO(DataSource dataSource) throws IOException {
		super(dataSource, "getUsers.sql");
	}

	@Override
	public List<User> getUsers(List<String> usernames) {
		SqlParameterSource paramSource = new MapSqlParameterSource("usernames", usernames);
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, new UserRowMapper());
	}

}
