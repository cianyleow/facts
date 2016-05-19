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
	public MapSqlParameterSource getNewSqlParameterSource(User object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("firstName", object.getFirstName());
		paramSource.addValue("lastName", object.getLastName());
		paramSource.addValue("userName", object.getUserName());
		paramSource.addValue("email", object.getEmail());
		return paramSource;
	}

	@Override
	public MapSqlParameterSource getUpdateSqlParameterSource(User updateObject, User existingObject) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("firstName", updateObject.getFirstName() == null ? existingObject.getFirstName() : updateObject.getFirstName());
		paramSource.addValue("lastName", updateObject.getLastName() == null ? existingObject.getLastName() : updateObject.getLastName());
		paramSource.addValue("email", updateObject.getEmail() == null ? existingObject.getEmail() : updateObject.getEmail());
		return paramSource;
	}

	@Override
	public String extractId(KeyHolder keyHolder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId(User object) {
		return object.getUserName();
	}
}
