package com.ic.ee.core.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class AbstractJdbcBaseDAO<T> {

	private final List<String> sqlStatements;

	private final NamedParameterJdbcTemplate jdbcTemplate;

	private final RowMapper<T> rowMapper;


	public AbstractJdbcBaseDAO(DataSource dataSource, RowMapper<T> rowMapper, String...fileNames) throws IOException {
		this.rowMapper = rowMapper;
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.sqlStatements = new ArrayList<String>();
		for(String fileName : fileNames) {
			this.sqlStatements.add(readSQLString(fileName));
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

	public RowMapper<T> getRowMapper() {
		return rowMapper;
	}
}
