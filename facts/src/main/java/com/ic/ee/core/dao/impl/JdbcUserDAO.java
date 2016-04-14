package com.ic.ee.core.dao.impl;

import java.io.IOException;

import javax.sql.DataSource;

import com.ic.ee.core.dao.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.api.UserDAO;
import com.ic.ee.core.dao.rowmapper.UserRowMapper;
import com.ic.ee.domain.user.User;

public class JdbcUserDAO extends AbstractJdbcBaseDAO<User, String> implements UserDAO {

	public JdbcUserDAO(DataSource dataSource) throws IOException {
		super(dataSource, new UserRowMapper(), User.class);
	}

	@Override
	public User getUser(String username) {
		return one(username);
	}
}
