package com.ic.ee.core.dao.api;

import com.ic.ee.domain.user.User;

public interface UserDAO {

	public User getUser(String username);
}
