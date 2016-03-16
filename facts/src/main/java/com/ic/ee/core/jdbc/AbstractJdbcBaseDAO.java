package com.ic.ee.core.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class AbstractJdbcBaseDAO {

	private final List<String> sqlStatements;

	private final NamedParameterJdbcTemplate jdbcTemplate;


	public AbstractJdbcBaseDAO(DataSource dataSource, String...fileNames) throws IOException {
		sqlStatements = new ArrayList<String>();
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
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

	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public List<String> getSqlStatements() {
		return sqlStatements;
	}
}
