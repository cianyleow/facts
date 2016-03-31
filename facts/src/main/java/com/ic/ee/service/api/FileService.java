package com.ic.ee.service.api;

import java.util.List;

import com.ic.ee.domain.common.file.File;

public interface FileService {

	public List<File> getFiles(List<Integer> fileIds);
}
