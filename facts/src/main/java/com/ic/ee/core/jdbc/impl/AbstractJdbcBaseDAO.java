package com.ic.ee.core.jdbc.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ic.ee.core.jdbc.api.JdbcBaseDAO;

public abstract class AbstractJdbcBaseDAO implements JdbcBaseDAO {

	private final Set<String> sqlStatements;

	private final JdbcTemplate jdbcTemplate;


	public AbstractJdbcBaseDAO(DataSource dataSource, Set<String> fileNames) throws IOException {
		sqlStatements = new HashSet<String>();
		jdbcTemplate = new JdbcTemplate(dataSource);
		for(String fileName : fileNames) {
			sqlStatements.add(readSQLString(fileName));
		}
	}

	private String readSQLString(String fileName) throws IOException {
		String fileLocationInClasspath = "sql/" + fileName;
		Resource resource = new ClassPathResource(fileLocationInClasspath);
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()),1024);
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            stringBuilder.append(line);
        }
        br.close();
        return stringBuilder.toString();
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public Set<String> getSqlStatements() {
		return sqlStatements;
	}
}
