package com.ic.ee.domain.common.relationship;

public enum EnrollmentLevel {
	NO_CREDIT("Not for Credit"),
	SUBMISSION_CREDIT("Credit for Submissions"),
	EXAM_CREDIT("Credit for Exams");

	private String description;

	EnrollmentLevel(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}