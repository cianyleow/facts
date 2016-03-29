package com.ic.ee.domain.user.auth;

public enum UserRole {
	STUDENT, MARKER, COURSE_OWNER, ADMIN;

	public UserAuthority asAuthorityFor(final AuthUser user) {
		final UserAuthority authority = new UserAuthority();
		authority.setAuthority("ROLE_" + toString());
		authority.setUser(user);;
		return authority;
	}

	public static UserRole valueOf(final UserAuthority authority) {
		switch(authority.getAuthority()) {
		case "ROLE_STUDENT":
			return STUDENT;
		case "ROLE_MAKRER":
			return MARKER;
		case "ROLE_COURSE_OWNER":
			return COURSE_OWNER;
		case "ROLE_ADMIN":
			return ADMIN;
		}
		throw new IllegalArgumentException("No role defined for authority: " + authority.getAuthority());
	}
}
