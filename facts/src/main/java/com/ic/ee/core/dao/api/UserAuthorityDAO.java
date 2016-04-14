package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.user.auth.UserAuthority;

public interface UserAuthorityDAO extends BaseDAO<UserAuthority, String> {
	public List<UserAuthority> getUserAuthorities(String username);
}
