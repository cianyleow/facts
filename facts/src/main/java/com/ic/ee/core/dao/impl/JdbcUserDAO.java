package com.ic.ee.core.dao.impl;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.ic.ee.core.dao.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.api.UserDAO;
import com.ic.ee.core.dao.rowmapper.UserRowMapper;
import com.ic.ee.domain.user.User;

public class JdbcUserDAO extends AbstractJdbcBaseDAO<User, String> implements UserDAO {

	public JdbcUserDAO(DataSource dataSource) throws IOException {
		super(dataSource, new UserRowMapper(), User.class, "getUsers.sql");
	}

	@Override
	public List<User> getUsers(List<String> usernames) {
		SqlParameterSource paramSource = new MapSqlParameterSource("usernames", usernames);
		return getJdbcTemplate().query(getSqlStatements().get(0), paramSource, getRowMapper());
	}

}
