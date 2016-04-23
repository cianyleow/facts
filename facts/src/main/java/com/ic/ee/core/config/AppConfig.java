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
import com.ic.ee.core.dao.api.CommentDAO;
import com.ic.ee.core.dao.api.CourseDAO;
import com.ic.ee.core.dao.api.CourseOwnerDAO;
import com.ic.ee.core.dao.api.DownloadLinkDAO;
import com.ic.ee.core.dao.api.EnrollmentDAO;
import com.ic.ee.core.dao.api.FeedbackDAO;
import com.ic.ee.core.dao.api.FileDAO;
import com.ic.ee.core.dao.api.FileRequirementDAO;
import com.ic.ee.core.dao.api.MarkComponentDAO;
import com.ic.ee.core.dao.api.MarkDAO;
import com.ic.ee.core.dao.api.MarkerDAO;
import com.ic.ee.core.dao.api.StudentDAO;
import com.ic.ee.core.dao.api.SubmissionDAO;
import com.ic.ee.core.dao.api.UserAuthorityDAO;
import com.ic.ee.core.dao.api.UserDAO;
import com.ic.ee.core.dao.jdbc.impl.JdbcAssignmentDAO;
import com.ic.ee.core.dao.jdbc.impl.JdbcAuthUserDAO;
import com.ic.ee.core.dao.jdbc.impl.JdbcCommentDAO;
import com.ic.ee.core.dao.jdbc.impl.JdbcCourseDAO;
import com.ic.ee.core.dao.jdbc.impl.JdbcCourseOwnerDAO;
import com.ic.ee.core.dao.jdbc.impl.JdbcDownloadLinkDAO;
import com.ic.ee.core.dao.jdbc.impl.JdbcEnrollmentDAO;
import com.ic.ee.core.dao.jdbc.impl.JdbcFeedbackDAO;
import com.ic.ee.core.dao.jdbc.impl.JdbcFileDAO;
import com.ic.ee.core.dao.jdbc.impl.JdbcFileRequirementDAO;
import com.ic.ee.core.dao.jdbc.impl.JdbcMarkComponentDAO;
import com.ic.ee.core.dao.jdbc.impl.JdbcMarkDAO;
import com.ic.ee.core.dao.jdbc.impl.JdbcMarkerDAO;
import com.ic.ee.core.dao.jdbc.impl.JdbcStudentDAO;
import com.ic.ee.core.dao.jdbc.impl.JdbcSubmissionDAO;
import com.ic.ee.core.dao.jdbc.impl.JdbcUserAuthorityDAO;
import com.ic.ee.core.dao.jdbc.impl.JdbcUserDAO;
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
    CourseOwnerDAO courseOwnerDAO() throws IOException {
    	return new JdbcCourseOwnerDAO(dataSource);
    }

	@Bean
	CourseDAO courseDAO() throws IOException {
		return new JdbcCourseDAO(dataSource);
	}

	@Bean
	AssignmentDAO assignmentDAO() throws IOException {
		return new JdbcAssignmentDAO(dataSource);
	}

	@Bean
	MarkerDAO markerDAO() throws IOException {
		return new JdbcMarkerDAO(dataSource);
	}

	@Bean
	AuthUserDAO authUserDAO() throws IOException {
		return new JdbcAuthUserDAO(dataSource);
	}

	@Bean
	UserAuthorityDAO userAuthorityDAO() throws IOException {
		return new JdbcUserAuthorityDAO(dataSource);
	}

	@Bean
	DownloadLinkDAO downloadLinkDAO() throws IOException {
		return new JdbcDownloadLinkDAO(dataSource);
	}

	@Bean
	UserDAO userDAO() throws IOException {
		return new JdbcUserDAO(dataSource);
	}

	@Bean
	EnrollmentDAO enrollmentDAO() throws IOException {
		return new JdbcEnrollmentDAO(dataSource);
	}

	@Bean
	StudentDAO studentDAO() throws IOException {
		return new JdbcStudentDAO(dataSource);
	}

	@Bean
	FileDAO fileDAO() throws IOException {
		return new JdbcFileDAO(dataSource);
	}

	@Bean
	MarkDAO markDAO() throws IOException {
		return new JdbcMarkDAO(dataSource);
	}

	@Bean
	CommentDAO commentDAO() throws IOException {
		return new JdbcCommentDAO(dataSource);
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
	CourseService courseService() throws IOException {
		return new SimpleCourseService(courseDAO(), assignmentDAO(), markerDAO(), courseOwnerDAO());
	}

	@Bean AssignmentService assignmentService() throws IOException, NoSuchAlgorithmException {
		return new SimpleAssignmentService(assignmentDAO(), markComponentDAO(), fileRequirementDAO(), submissionDAO(), fileDAO(), courseDAO(), fileService());
	}

	@Bean AuthUserService authUserService() throws IOException {
		return new SimpleAuthUserService(authUserDAO(), userAuthorityDAO());
	}

	@Bean
	TokenAuthenticationService tokenAuthenticationService() throws IOException {
		return new SimpleTokenAuthenticationService(tokenSecret, userService());
	}

	@Bean
	UserService userService() throws IOException {
		return new SimpleUserService(userDAO());
	}

	@Bean
	TokenUserDetailsService tokenUserDetailsService() throws IOException {
		return new SimpleTokenUserDetailsService(authUserService(), accountStatusUserDetailsChecker());
	}

	@Bean
	FileService fileService() throws NoSuchAlgorithmException, IOException {
		return new SimpleFileService(fileDAO(), downloadLinkDAO(), hashUtil(), fileUtils());
	}

	@Bean
	EnrollmentService enrollmentService() throws IOException {
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
	SubmissionService submissionService() throws IOException, NoSuchAlgorithmException {
		return new SimpleSubmissionService(submissionDAO(), assignmentDAO(), studentDAO(), feedbackDAO(), fileDAO(), fileService(), submissionFileValidator());
	}

	@Bean
	FeedbackService feedbackService() throws IOException {
		return new SimpleFeedbackService(feedbackDAO(), submissionDAO(), markDAO(), commentDAO(), markerDAO());
	}

	@Bean
	HashUtil hashUtil() throws NoSuchAlgorithmException {
			return new Sha256HashUtil();
	}

	@Bean
	SubmissionFileValidator submissionFileValidator() {
		return new SubmissionFileValidator();
	}

	@Bean
	FileUtils fileUtils() throws NoSuchAlgorithmException {
		return new SimpleFileUtils(baseFileLocation, hashUtil());
	}
}
