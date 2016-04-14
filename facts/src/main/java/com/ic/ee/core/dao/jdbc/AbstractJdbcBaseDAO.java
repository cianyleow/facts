package com.ic.ee.core.dao.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ic.ee.core.dao.BaseDAO;

public abstract class AbstractJdbcBaseDAO<T, T1> implements BaseDAO<T, T1> {

	private final List<String> sqlStatements;

	private final String oneSqlStatement;

	private final String severalSqlStatement;

	private final String createSqlStatement;

	private final String updateSqlStatement;

	private final String deleteSqlStatement;

	private final NamedParameterJdbcTemplate jdbcTemplate;

	private final RowMapper<T> rowMapper;

	public AbstractJdbcBaseDAO(DataSource dataSource, RowMapper<T> rowMapper, Class<T> genericType, String...fileNames) throws IOException {
		this.rowMapper = rowMapper;
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.sqlStatements = new ArrayList<String>();
		for(String fileName : fileNames) {
			this.sqlStatements.add(readSQLString(fileName));
		}
		String tableName = genericType.getSimpleName();
		this.oneSqlStatement = readSQLString("base/one" + tableName + ".sql");
		this.severalSqlStatement = readSQLString("base/several" + tableName + ".sql");
		this.createSqlStatement = readSQLString("base/create" + tableName + ".sql");
		this.updateSqlStatement = readSQLString("base/update" + tableName + ".sql");
		this.deleteSqlStatement = readSQLString("base/delete" + tableName + ".sql");

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

	@Override
	public T one(T1 id) {
		SqlParameterSource paramSource = new MapSqlParameterSource("id", id);
		return getJdbcTemplate().queryForObject(oneSqlStatement, paramSource, getRowMapper());
	}

	@Override
	public List<T> several(List<T1> ids) {
		SqlParameterSource paramSource = new MapSqlParameterSource("ids", ids);
		return getJdbcTemplate().query(severalSqlStatement, paramSource, getRowMapper());
	}

	@Override
	public T create(T newObject) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(createSqlStatement, getSqlParameterSource(newObject), keyHolder);
		T1 key = extractId(keyHolder);
		return one(key);
	}

	@Override
	public T update(T updateObject) {
		MapSqlParameterSource sqlParameterSource = getSqlParameterSource(updateObject);
		sqlParameterSource.addValue("id", getId(updateObject));
		getJdbcTemplate().update(updateSqlStatement, sqlParameterSource);
		return one(getId(updateObject));
	}

	public abstract MapSqlParameterSource getSqlParameterSource(T object);

	public abstract T1 extractId(KeyHolder keyHolder);

	public abstract T1 getId(T object);

	@Override
	public boolean delete(T1 id) {
		SqlParameterSource paramSource = new MapSqlParameterSource("id", id);
		return 1 == getJdbcTemplate().update(deleteSqlStatement, paramSource);
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
