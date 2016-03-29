package com.ic.ee.core.jdbc.api;

import java.util.List;

import com.ic.ee.domain.user.auth.AuthUser;

public interface AuthUserDAO {
	public List<AuthUser> getAuthUsers(List<String> usernames);
}
