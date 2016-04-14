package com.ic.ee.core.dao.jdbc.impl;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.ic.ee.core.dao.api.AuthUserDAO;
import com.ic.ee.core.dao.jdbc.AbstractJdbcBaseDAO;
import com.ic.ee.core.dao.jdbc.rowmapper.AuthUserRowMapper;
import com.ic.ee.domain.user.auth.AuthUser;

public class JdbcAuthUserDAO extends AbstractJdbcBaseDAO<AuthUser, String> implements AuthUserDAO {
	Logger logger = Logger.getLogger(this.getClass());

	public JdbcAuthUserDAO(DataSource dataSource) throws IOException {
		super(dataSource, new AuthUserRowMapper(), AuthUser.class);
	}
}
