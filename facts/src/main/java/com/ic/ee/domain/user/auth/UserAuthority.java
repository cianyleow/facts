package com.ic.ee.domain.user.auth;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserAuthority implements GrantedAuthority {

	private static final long serialVersionUID = -8271802520292824891L;

	@JsonIgnore
	private AuthUser user;

	private String authority;

	public AuthUser getUser() {
		return user;
	}

	public void setUser(AuthUser user) {
		this.user = user;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
