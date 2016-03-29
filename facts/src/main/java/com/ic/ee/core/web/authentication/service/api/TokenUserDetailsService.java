package com.ic.ee.core.web.authentication.service.api;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ic.ee.domain.user.auth.AuthUser;

public interface TokenUserDetailsService extends UserDetailsService {

	@Override
	public AuthUser loadUserByUsername(String username) throws UsernameNotFoundException;
}
