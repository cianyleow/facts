package com.ic.ee.core.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ic.ee.core.jdbc.api.AssignmentDAO;
import com.ic.ee.core.jdbc.api.CourseDAO;
import com.ic.ee.core.jdbc.impl.JdbcAssignmentDAO;
import com.ic.ee.core.jdbc.impl.JdbcCourseDAO;
import com.ic.ee.core.service.api.AssignmentService;
import com.ic.ee.core.service.api.CourseService;
import com.ic.ee.core.service.impl.SimpleAssignmentService;
import com.ic.ee.core.service.impl.SimpleCourseService;

@Configuration
public class AppConfig {
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private DataSource dataSource;

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
			logger.error("CourseDAO threw IO Exception: " + ioe.toString());
			System.exit(-1);
		}
		return null;
	}

	@Bean
	public CourseService courseService() {
		return new SimpleCourseService(courseDAO());
	}

	@Bean AssignmentService assignmentService() {
		return new SimpleAssignmentService(assignmentDAO());
	}
}
