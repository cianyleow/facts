package com.ic.ee.core.web.authentication.service.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

import com.ic.ee.domain.user.auth.UserAuthentication;

public interface TokenAuthenticationService {

	public void addAuthentication(HttpServletResponse response, UserAuthentication authentication);

	public Authentication getAuthentication(HttpServletRequest request);
}
