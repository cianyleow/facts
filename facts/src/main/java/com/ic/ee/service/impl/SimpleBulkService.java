package com.ic.ee.service.impl;

import java.util.List;

import com.ic.ee.domain.bulk.BulkType;
import com.ic.ee.domain.bulk.download.BulkDownload;
import com.ic.ee.service.api.BulkService;

public class SimpleBulkService implements BulkService {

	@Override
	public <T> BulkDownload<T> getBulkDownload(BulkType bulkType, List<T> rows) {
		BulkDownload<T> bulkDownload = new BulkDownload<T>();
		bulkDownload.setAccessors(bulkType.getAccessors());
		bulkDownload.setHeaders(bulkType.getHeaders());
		bulkDownload.setRows(rows);
		return bulkDownload;
	}

}
