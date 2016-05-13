package com.ic.ee.domain.bulk.download;

import java.util.List;

public class BulkDownload<T> {

	private String[] headers;

	private String[] accessors;

	private List<T> rows;

	public String[] getHeaders() {
		return headers;
	}

	public void setHeaders(String[] headers) {
		this.headers = headers;
	}

	public String[] getAccessors() {
		return accessors;
	}

	public void setAccessors(String[] accessors) {
		this.accessors = accessors;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
