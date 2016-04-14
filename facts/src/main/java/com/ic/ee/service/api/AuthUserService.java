package com.ic.ee.service.api;

import com.ic.ee.domain.user.auth.AuthUser;

public interface AuthUserService {
	public AuthUser getAuthUser(String username);
}
