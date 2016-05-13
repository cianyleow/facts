package com.ic.ee.service.api;

import java.util.List;

import com.ic.ee.domain.bulk.BulkType;
import com.ic.ee.domain.bulk.download.BulkDownload;

public interface BulkService {

	public <T> BulkDownload<T> getBulkDownload(BulkType bulkType, List<T> rows);

}
