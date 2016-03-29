package com.ic.ee.core.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;

import com.ic.ee.core.jdbc.api.AssignmentDAO;
import com.ic.ee.core.jdbc.api.AuthUserDAO;
import com.ic.ee.core.jdbc.api.CourseDAO;
import com.ic.ee.core.jdbc.api.UserAuthorityDAO;
import com.ic.ee.core.jdbc.impl.JdbcAssignmentDAO;
import com.ic.ee.core.jdbc.impl.JdbcAuthUserDAO;
import com.ic.ee.core.jdbc.impl.JdbcCourseDAO;
import com.ic.ee.core.jdbc.impl.JdbcUserAuthorityDAO;
import com.ic.ee.core.web.authentication.service.api.TokenAuthenticationService;
import com.ic.ee.core.web.authentication.service.api.TokenUserDetailsService;
import com.ic.ee.core.web.authentication.service.impl.SimpleTokenAuthenticationService;
import com.ic.ee.core.web.authentication.service.impl.SimpleTokenUserDetailsService;
import com.ic.ee.service.api.AssignmentService;
import com.ic.ee.service.api.AuthUserService;
import com.ic.ee.service.api.CourseService;
import com.ic.ee.service.impl.SimpleAssignmentService;
import com.ic.ee.service.impl.SimpleAuthUserService;
import com.ic.ee.service.impl.SimpleCourseService;

@Configuration
public class AppConfig {
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private DataSource dataSource;

	@Value("${token.secret}")
	String tokenSecret;

	@Bean
	public CourseDAO courseDAO() {
		try {
			return new JdbcCourseDAO(dataSource);
		} catch(IOException ioe) {
			logger.error("CourseDAO threw IO Exception: " + ioe.toString());
			System.exit(-1);
		}
		return null;
	}

	@Bean
	public AssignmentDAO assignmentDAO() {
		try {
			return new JdbcAssignmentDAO(dataSource);
		} catch(IOException ioe) {
			logger.error("AssignmentDAO threw IO Exception: " + ioe.toString());
			System.exit(-1);
		}
		return null;
	}

	@Bean
	public AuthUserDAO authUserDAO() {
		try {
			return new JdbcAuthUserDAO(dataSource);
		} catch(IOException ioe) {
			logger.error("AuthUserDAO threw IO Exception: " + ioe.toString());
			System.exit(-1);
		}
		return null;
	}

	@Bean
	public UserAuthorityDAO userAuthorityDAO() {
		try {
			return new JdbcUserAuthorityDAO(dataSource);
		} catch(IOException ioe) {
			logger.error("UserAuthorityDAO threw IO Exception: " + ioe.toString());
			System.exit(-1);
		}
		return null;
	}

	@Bean
	public AccountStatusUserDetailsChecker accountStatusUserDetailsChecker() {
		return new AccountStatusUserDetailsChecker();
	}

	@Bean
	public CourseService courseService() {
		return new SimpleCourseService(courseDAO());
	}

	@Bean AssignmentService assignmentService() {
		return new SimpleAssignmentService(assignmentDAO());
	}

	@Bean AuthUserService authUserService() {
		return new SimpleAuthUserService(authUserDAO(), userAuthorityDAO());
	}

	@Bean
	TokenAuthenticationService tokenAuthenticationService() {
		return new SimpleTokenAuthenticationService(tokenSecret);
	}

	@Bean
	TokenUserDetailsService tokenUserDetailsService() {
		return new SimpleTokenUserDetailsService(authUserService(), accountStatusUserDetailsChecker());
	}
}
