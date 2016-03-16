package com.ic.ee.core.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ic.ee.core.jdbc.api.CourseDAO;
import com.ic.ee.core.jdbc.impl.JdbcCourseDAO;
import com.ic.ee.core.service.api.CourseService;
import com.ic.ee.core.service.impl.SimpleCourseService;

@Configuration
public class AppConfig {
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private DataSource dataSource;

	@Bean
	public CourseDAO courseDAO() {
		logger.info("Creating new CourseDAO");
		try {
			return new JdbcCourseDAO(dataSource);
		} catch(IOException ioe) {
			logger.error("CourseDAO threw IO Exception: " + ioe.toString());
			System.exit(-1);
		}
		return null;
	}

	@Bean
	public CourseService courseService() {
		logger.info("Creating new CourseService");
		return new SimpleCourseService(courseDAO());
	}
}
