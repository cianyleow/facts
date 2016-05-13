package com.ic.ee.core.dao.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.course.Course;
import com.ic.ee.domain.course.announcement.Announcement;
import com.ic.ee.domain.user.courseowner.CourseOwner;

public class AnnouncementRowMapper implements RowMapper<Announcement> {

	@Override
	public Announcement mapRow(ResultSet rs, int rowNum) throws SQLException {
		Announcement announcement = new Announcement(rs.getInt("announcementId"));
		announcement.setContent(rs.getString("content"));
		announcement.setTitle(rs.getString("title"));
		announcement.setCreationTime(rs.getTimestamp("creationTime"));
		announcement.setCourseOwner(new CourseOwner(rs.getString("username")));
		announcement.setCourse(new Course(rs.getInt("courseId")));
		return announcement;
	}

}
