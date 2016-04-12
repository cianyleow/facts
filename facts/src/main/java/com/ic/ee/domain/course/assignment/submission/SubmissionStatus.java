package com.ic.ee.domain.course.assignment.submission;

public enum SubmissionStatus {
	ONTIME("This submission was received on time."),
	LATE("This submission was received late."),
	MARKER_ASSIGNED("This submission has been assigned to a marker."),
	MARKING("This submission is being marked."),
	MARKED("This submission has been marked.");

	private final String message;

	private SubmissionStatus(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
