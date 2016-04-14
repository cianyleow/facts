package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.api.UserDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.UserRowMapper;
import com.ic.ee.domain.user.User;

public class JdbcUserDAO extends AbstractJdbcBaseDAO<User, String> implements UserDAO {

	public JdbcUserDAO(DataSource dataSource) throws IOException {
		super(dataSource, new UserRowMapper(), User.class);
	}

	@Override
	public MapSqlParameterSource getSqlParameterSource(User object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String extractKey(KeyHolder keyHolder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKey(User object) {
		// TODO Auto-generated method stub
		return null;
	}
}