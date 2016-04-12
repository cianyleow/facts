package com.ic.ee.core.config;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

import com.ic.ee.core.dao.api.AssignmentDAO;
import com.ic.ee.core.dao.api.AuthUserDAO;
import com.ic.ee.core.dao.api.CourseDAO;
import com.ic.ee.core.dao.api.EnrollmentDAO;
import com.ic.ee.core.dao.api.FeedbackDAO;
import com.ic.ee.core.dao.api.FileDAO;
import com.ic.ee.core.dao.api.FileRequirementDAO;
import com.ic.ee.core.dao.api.MarkComponentDAO;
import com.ic.ee.core.dao.api.SubmissionDAO;
import com.ic.ee.core.dao.api.UserAuthorityDAO;
import com.ic.ee.core.dao.api.UserDAO;
import com.ic.ee.core.dao.impl.JdbcAssignmentDAO;
import com.ic.ee.core.dao.impl.JdbcAuthUserDAO;
import com.ic.ee.core.dao.impl.JdbcCourseDAO;
import com.ic.ee.core.dao.impl.JdbcEnrollmentDAO;
import com.ic.ee.core.dao.impl.JdbcFeedbackDAO;
import com.ic.ee.core.dao.impl.JdbcFileDAO;
import com.ic.ee.core.dao.impl.JdbcFileRequirementDAO;
import com.ic.ee.core.dao.impl.JdbcMarkComponentDAO;
import com.ic.ee.core.dao.impl.JdbcSubmissionDAO;
import com.ic.ee.core.dao.impl.JdbcUserAuthorityDAO;
import com.ic.ee.core.dao.impl.JdbcUserDAO;
import com.ic.ee.core.validator.SubmissionFileValidator;
import com.ic.ee.core.web.authentication.service.api.TokenAuthenticationService;
import com.ic.ee.core.web.authentication.service.api.TokenUserDetailsService;
import com.ic.ee.core.web.authentication.service.impl.SimpleTokenAuthenticationService;
import com.ic.ee.core.web.authentication.service.impl.SimpleTokenUserDetailsService;
import com.ic.ee.service.api.AssignmentService;
import com.ic.ee.service.api.AuthUserService;
import com.ic.ee.service.api.CourseService;
import com.ic.ee.service.api.EnrollmentService;
import com.ic.ee.service.api.FeedbackService;
import com.ic.ee.service.api.FileRequirementService;
import com.ic.ee.service.api.FileService;
import com.ic.ee.service.api.MarkComponentService;
import com.ic.ee.service.api.SubmissionService;
import com.ic.ee.service.api.UserService;
import com.ic.ee.service.impl.SimpleAssignmentService;
import com.ic.ee.service.impl.SimpleAuthUserService;
import com.ic.ee.service.impl.SimpleCourseService;
import com.ic.ee.service.impl.SimpleEnrollmentService;
import com.ic.ee.service.impl.SimpleFeedbackService;
import com.ic.ee.service.impl.SimpleFileRequirementService;
import com.ic.ee.service.impl.SimpleFileService;
import com.ic.ee.service.impl.SimpleMarkComponentService;
import com.ic.ee.service.impl.SimpleSubmissionService;
import com.ic.ee.service.impl.SimpleUserService;
import com.ic.ee.util.FileUtils;
import com.ic.ee.util.HashUtil;
import com.ic.ee.util.Sha256HashUtil;
import com.ic.ee.util.SimpleFileUtils;

@Configuration
public class AppConfig {
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private DataSource dataSource;

	@Value("${token.secret}")
	String tokenSecret;

	@Value("${facts.baseFileLocation}")
	String baseFileLocation;

	@Bean
    CommonsMultipartResolver commonsMultipartResolver() {
        final CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(-1);
        return commonsMultipartResolver;
    }

    @Bean
    FilterRegistrationBean multipartFilterRegistrationBean() {
        final MultipartFilter multipartFilter = new MultipartFilter();
        final FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(multipartFilter);
        filterRegistrationBean.addInitParameter("multipartResolverBeanName", "commonsMultipartResolver");
        return filterRegistrationBean;
    }

	@Bean
	CourseDAO courseDAO() {
		try {
			return new JdbcCourseDAO(dataSource);
		} catch(IOException ioe) {
			logger.error("CourseDAO threw IO Exception: " + ioe.toString());
			System.exit(-1);
		}
		return null;
	}

	@Bean
	AssignmentDAO assignmentDAO() {
		try {
			return new JdbcAssignmentDAO(dataSource);
		} catch(IOException ioe) {
			logger.error("AssignmentDAO threw IO Exception: " + ioe.toString());
			System.exit(-1);
		}
		return null;
	}

	@Bean
	AuthUserDAO authUserDAO() {
		try {
			return new JdbcAuthUserDAO(dataSource);
		} catch(IOException ioe) {
			logger.error("AuthUserDAO threw IO Exception: " + ioe.toString());
			System.exit(-1);
		}
		return null;
	}

	@Bean
	UserAuthorityDAO userAuthorityDAO() {
		try {
			return new JdbcUserAuthorityDAO(dataSource);
		} catch(IOException ioe) {
			logger.error("UserAuthorityDAO threw IO Exception: " + ioe.toString());
			System.exit(-1);
		}
		return null;
	}

	@Bean
	UserDAO userDAO() {
		try {
			return new JdbcUserDAO(dataSource);
		} catch(IOException ioe) {
			logger.error("UserDAO threw IO Exception: " + ioe.toString());
			System.exit(-1);
		}
		return null;
	}

	@Bean
	EnrollmentDAO enrollmentDAO() {
		try {
			return new JdbcEnrollmentDAO(dataSource);
		} catch(IOException ioe) {
			logger.error("EnrollmentDAO threw IO Exception: " + ioe.toString());
			System.exit(-1);
		}
		return null;
	}

	@Bean
	FileDAO fileDAO() {
		try {
			return new JdbcFileDAO(dataSource);
		} catch(IOException ioe) {
			logger.error("FileDAO threw IO Exception: " + ioe.toString());
			System.exit(-1);
		}
		return null;
	}


	@Bean
	FeedbackDAO feedbackDAO() throws IOException {
		return new JdbcFeedbackDAO(dataSource);
	}

	@Bean
	MarkComponentDAO markComponentDAO() throws IOException {
		return new JdbcMarkComponentDAO(dataSource);
	}

	@Bean
	FileRequirementDAO fileRequirementDAO() throws IOException {
		return new JdbcFileRequirementDAO(dataSource);
	}

	@Bean
	SubmissionDAO submissionDAO() throws IOException {
		return new JdbcSubmissionDAO(dataSource);
	}

	@Bean
	AccountStatusUserDetailsChecker accountStatusUserDetailsChecker() {
		return new AccountStatusUserDetailsChecker();
	}

	@Bean
	CourseService courseService() {
		return new SimpleCourseService(courseDAO(), assignmentDAO());
	}

	@Bean AssignmentService assignmentService() throws IOException {
		return new SimpleAssignmentService(assignmentDAO(), markComponentService(), fileRequirementService(), fileService());
	}

	@Bean AuthUserService authUserService() {
		return new SimpleAuthUserService(authUserDAO(), userAuthorityDAO());
	}

	@Bean
	TokenAuthenticationService tokenAuthenticationService() {
		return new SimpleTokenAuthenticationService(tokenSecret);
	}

	@Bean
	UserService userService() {
		return new SimpleUserService(userDAO());
	}

	@Bean
	TokenUserDetailsService tokenUserDetailsService() {
		return new SimpleTokenUserDetailsService(authUserService(), accountStatusUserDetailsChecker());
	}

	@Bean
	FileService fileService() {
		return new SimpleFileService(fileDAO(), hashUtil(), fileUtils());
	}

	@Bean
	EnrollmentService enrollmentService() {
		return new SimpleEnrollmentService(enrollmentDAO());
	}

	@Bean
	FileRequirementService fileRequirementService() throws IOException {
		return new SimpleFileRequirementService(fileRequirementDAO());
	}

	@Bean
	MarkComponentService markComponentService() throws IOException {
		return new SimpleMarkComponentService(markComponentDAO());
	}

	@Bean
	SubmissionService submissionService() throws IOException {
		return new SimpleSubmissionService(submissionDAO(), assignmentService(), fileService(), submissionFileValidator());
	}

	@Bean
	FeedbackService feedbackService() throws IOException {
		return new SimpleFeedbackService(feedbackDAO());
	}

	@Bean
	HashUtil hashUtil() {
		try {
			return new Sha256HashUtil();
		} catch (NoSuchAlgorithmException e) {
			logger.error("Hash Util algorithm does not exist.");
			System.exit(-1);
		}
		return null;
	}

	@Bean
	SubmissionFileValidator submissionFileValidator() {
		return new SubmissionFileValidator();
	}

	@Bean
	FileUtils fileUtils() {
		return new SimpleFileUtils(baseFileLocation, hashUtil());
	}
}
