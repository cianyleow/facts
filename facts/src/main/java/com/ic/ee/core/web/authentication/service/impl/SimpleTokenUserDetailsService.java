package com.ic.ee.core.web.authentication.service.impl;

import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ic.ee.core.web.authentication.service.api.TokenUserDetailsService;
import com.ic.ee.domain.user.auth.AuthUser;
import com.ic.ee.service.api.AuthUserService;

public class SimpleTokenUserDetailsService implements TokenUserDetailsService {

	private final AuthUserService authUserService;
	private final AccountStatusUserDetailsChecker detailsChecker;

	public SimpleTokenUserDetailsService(AuthUserService authUserService, AccountStatusUserDetailsChecker detailsChecker) {
		this.authUserService = authUserService;
		this.detailsChecker = detailsChecker;
	}

	@Override
	public AuthUser loadUserByUsername(String username) throws UsernameNotFoundException {
		AuthUser user = authUserService.getAuthUser(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		detailsChecker.check(user);
		return user;
	}

}
