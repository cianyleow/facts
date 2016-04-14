package com.ic.ee.core.dao.api;

import com.ic.ee.domain.user.auth.AuthUser;

public interface AuthUserDAO {
	public AuthUser getAuthUser(String username);
}
