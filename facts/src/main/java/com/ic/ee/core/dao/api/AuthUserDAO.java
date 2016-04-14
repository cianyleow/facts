package com.ic.ee.core.dao.api;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.user.auth.AuthUser;

public interface AuthUserDAO extends BaseDAO<AuthUser, String> {
	public AuthUser getAuthUser(String username);
}
