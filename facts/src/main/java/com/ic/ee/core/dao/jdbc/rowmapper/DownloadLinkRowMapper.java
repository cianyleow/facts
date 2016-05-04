package com.ic.ee.core.dao.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.common.file.DownloadLink;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.user.User;

public class DownloadLinkRowMapper implements RowMapper<DownloadLink> {

	@Override
	public DownloadLink mapRow(ResultSet rs, int rowNum) throws SQLException {
		DownloadLink dl = new DownloadLink(rs.getInt("downloadLinkId"));
		dl.setFile(new File(rs.getInt("fileId")));
		dl.setLink(rs.getString("link"));
		dl.setValidFrom(rs.getTimestamp("validFrom"));
		dl.setUser(new User(rs.getString("username")));
		dl.setUsed(rs.getBoolean("used"));
		return dl;
	}

}
