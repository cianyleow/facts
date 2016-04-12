package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.domain.user.User;

public interface UserDAO {

	public List<User> getUsers(List<String> usernames);
}
