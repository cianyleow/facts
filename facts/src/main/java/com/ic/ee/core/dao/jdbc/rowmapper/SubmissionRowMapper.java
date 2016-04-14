package com.ic.ee.core.dao.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.course.assignment.submission.Submission;
import com.ic.ee.domain.course.assignment.submission.SubmissionStatus;
import com.ic.ee.domain.user.student.Student;

public class SubmissionRowMapper implements RowMapper<Submission> {

	@Override
	public Submission mapRow(ResultSet rs, int rowNum) throws SQLException {
		Submission submission = new Submission(rs.getInt("submissionId"));
		submission.setAssignment(new Assignment(rs.getInt("assignmentId")));
		submission.setSubmitter(new Student(rs.getString("username")));
		submission.setCreationTime(rs.getDate("creationTime"));
		submission.setComment(rs.getString("comment"));
		submission.setSubmissionStatus(SubmissionStatus.valueOf(rs.getString("submissionStatus")));
		return submission;
	}

}
