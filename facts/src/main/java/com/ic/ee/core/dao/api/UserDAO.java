package com.ic.ee.core.dao.api;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.user.User;

public interface UserDAO extends BaseDAO<User, String> {

	public User getUser(String username);
}
