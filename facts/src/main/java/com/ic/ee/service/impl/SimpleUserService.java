package com.ic.ee.service.impl;

import com.ic.ee.core.dao.api.UserDAO;
import com.ic.ee.domain.user.User;
import com.ic.ee.service.api.UserService;

public class SimpleUserService implements UserService {

	private final UserDAO userDAO;

	public SimpleUserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User getUser(String username) {
		return userDAO.one(username);
	}
}
