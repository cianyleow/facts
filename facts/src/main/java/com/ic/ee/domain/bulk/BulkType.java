package com.ic.ee.domain.bulk;

import com.ic.ee.domain.common.feedback.comment.Comment;

public enum BulkType {
	COMMENT(Comment.getHeaders(), Comment.getAccessors());

	private String[] headers;

	private String[] accessors;

	private BulkType(String[] headers, String[] accessors) {
		this.headers = headers;
		this.accessors = accessors;
	}

	public String[] getHeaders() {
		return headers;
	}

	public String[] getAccessors() {
		return accessors;
	}
}
