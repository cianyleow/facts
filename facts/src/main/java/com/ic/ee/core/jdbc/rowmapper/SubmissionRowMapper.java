package com.ic.ee.core.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.course.assignment.submission.SubmissionStatus;

public class SubmissionRowMapper implements RowMapper<Submission> {

	@Override
	public Submission mapRow(ResultSet rs, int rowNum) throws SQLException {
		Submission submission = new Submission();
		submission.setSubmissionId(rs.getInt("submissionId"));
		submission.setCreationTime(rs.getDate("creationTime"));
		submission.setComment(rs.getString("comment"));
		submission.setSubmissionStatus(SubmissionStatus.valueOf(rs.getString("submissionStatus")));
		return submission;
	}

}
