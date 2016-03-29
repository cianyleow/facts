package com.ic.ee.service.impl;

import java.util.Collections;
import java.util.List;

import com.ic.ee.core.jdbc.api.UserDAO;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.user.User;
import com.ic.ee.service.api.UserService;
import com.ic.ee.util.ElementExtractor;

public class SimpleUserService implements UserService {

	private final UserDAO userDAO;

	public SimpleUserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User getUser(String username) throws NoResultsReturnedException, TooManyResultsReturnedException{
		List<User> users = userDAO.getUsers(Collections.singletonList(username));
		return ElementExtractor.extractOne(users);
	}
}
