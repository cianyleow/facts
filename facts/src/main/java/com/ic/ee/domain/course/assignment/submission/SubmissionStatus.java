package com.ic.ee.domain.course.assignment.submission;

public enum SubmissionStatus {
	ONTIME(false, false),
	LATE(true, false),
	WITH_EXTENSION(true, true);

	private Boolean late;
	private Boolean extended;

	private SubmissionStatus(Boolean late, Boolean extended) {
		this.late = late;
		this.extended = extended;
	}

	public Boolean getLate() {
		return late;
	}

	public void setLate(Boolean late) {
		this.late = late;
	}

	public Boolean getExtended() {
		return extended;
	}

	public void setExtended(Boolean extended) {
		this.extended = extended;
	}
}
