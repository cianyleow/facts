package com.ic.ee.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.user.User;
import com.ic.ee.service.api.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/users/me")
	public User getUser(Principal user) throws NoResultsReturnedException, TooManyResultsReturnedException {
		return userService.getUser(user.getName());
	}
}
