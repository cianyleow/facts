package com.ic.ee.core.jdbc.api;

import java.util.List;

import com.ic.ee.domain.common.file.File;

public interface FileDAO {

	public List<File> getFiles(List<Integer> fileIds);

}
