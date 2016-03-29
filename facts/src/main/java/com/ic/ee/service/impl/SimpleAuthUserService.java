package com.ic.ee.service.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import com.ic.ee.core.jdbc.api.AuthUserDAO;
import com.ic.ee.core.jdbc.api.UserAuthorityDAO;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.user.auth.AuthUser;
import com.ic.ee.domain.user.auth.UserAuthority;
import com.ic.ee.service.api.AuthUserService;

public class SimpleAuthUserService implements AuthUserService {

	private final AuthUserDAO authUserDAO;
	private final UserAuthorityDAO userAuthorityDAO;

	public SimpleAuthUserService(AuthUserDAO authUserDAO, UserAuthorityDAO userAuthorityDAO) {
		this.authUserDAO = authUserDAO;
		this.userAuthorityDAO = userAuthorityDAO;
	}

	@Override
	public AuthUser getAuthUser(String username) throws NoResultsReturnedException, TooManyResultsReturnedException {
		List<AuthUser> authUsers = authUserDAO.getAuthUsers(Collections.singletonList(username));
		if(authUsers == null) {
			throw new NoResultsReturnedException();
		} else if(authUsers.isEmpty()) {
			throw new NoResultsReturnedException();
		} else if(authUsers.size() > 1) {
			throw new TooManyResultsReturnedException();
		}
		AuthUser authUser = authUsers.get(0);

		// Decorate authUser with user authorities.
		decorateAuthUserWithAuthorities(authUser);
		return authUser;
	}

	private void decorateAuthUserWithAuthorities(AuthUser authUser) {
		List<UserAuthority> userAuthorities = userAuthorityDAO.getUserAuthorities(authUser.getUsername());
		for(UserAuthority userAuthority : userAuthorities) {
			userAuthority.setUser(authUser);
		}
		authUser.setAuthorities(new HashSet<UserAuthority>(userAuthorities));
	}
}
