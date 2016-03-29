package com.ic.ee.core.jdbc.api;

import java.util.List;

import com.ic.ee.domain.user.auth.UserAuthority;

public interface UserAuthorityDAO {
	public List<UserAuthority> getUserAuthorities(String username);
}
