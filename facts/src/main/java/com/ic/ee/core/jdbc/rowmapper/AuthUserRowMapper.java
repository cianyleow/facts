package com.ic.ee.core.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.user.auth.AuthUser;

public class AuthUserRowMapper implements RowMapper<AuthUser>{

	@Override
	public AuthUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		AuthUser user = new AuthUser();
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		return user;
	}

}
