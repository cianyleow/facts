package com.ic.ee.core.web.authentication.handler.api;

import com.ic.ee.domain.user.auth.AuthUser;

public interface TokenHandler {
	public AuthUser parseUserFromToken(String token);

	public String createTokenForUser(AuthUser user);
}

