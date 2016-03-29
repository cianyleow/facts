package com.ic.ee.core.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.user.auth.UserAuthority;

public class UserAuthorityRowMapper implements RowMapper<UserAuthority> {

	@Override
	public UserAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserAuthority authority = new UserAuthority();
		authority.setAuthority(rs.getString("authority"));
		return authority;
	}

}
