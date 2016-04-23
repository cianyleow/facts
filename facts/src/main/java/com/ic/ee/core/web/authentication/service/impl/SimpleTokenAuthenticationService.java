package com.ic.ee.core.web.authentication.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import org.springframework.security.core.Authentication;

import com.ic.ee.core.web.authentication.handler.api.TokenHandler;
import com.ic.ee.core.web.authentication.handler.impl.SimpleTokenHandler;
import com.ic.ee.core.web.authentication.service.api.TokenAuthenticationService;
import com.ic.ee.domain.user.auth.AuthUser;
import com.ic.ee.domain.user.auth.UserAuthentication;
import com.ic.ee.service.api.UserService;

public class SimpleTokenAuthenticationService implements TokenAuthenticationService {

	private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";
	private static final long ONE_DAY = 1000 * 60 * 60 * 24 * 1;

	private final TokenHandler tokenHandler;

	private final UserService userService;

	public SimpleTokenAuthenticationService(String secret, UserService userService) {
		tokenHandler = new SimpleTokenHandler(DatatypeConverter.parseBase64Binary(secret));
		this.userService = userService;
	}

	@Override
	public void addAuthentication(HttpServletResponse response, UserAuthentication authentication) {
		final AuthUser user = authentication.getDetails();
		user.setExpires(System.currentTimeMillis() + ONE_DAY);
		user.setUserDetails(userService.getUser(user.getUsername()));
		response.addHeader(AUTH_HEADER_NAME, tokenHandler.createTokenForUser(user));
	}

	@Override
	public Authentication getAuthentication(HttpServletRequest request) {
		final String token = request.getHeader(AUTH_HEADER_NAME);
		if (token != null) {
			final AuthUser user = tokenHandler.parseUserFromToken(token);
			if (user != null) {
				return new UserAuthentication(user);
			}
		}
		return null;
	}

}
