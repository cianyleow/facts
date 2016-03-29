package com.ic.ee.service.api;

import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.user.User;

public interface UserService {
	public User getUser(String username) throws NoResultsReturnedException, TooManyResultsReturnedException;
}
