package com.ic.ee.service.api;

import org.springframework.web.multipart.MultipartFile;

import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.course.assignment.Assignment;

public interface AssignmentService {

	public Assignment getAssignment(Integer assignmentId, boolean lite) throws NoResultsReturnedException, TooManyResultsReturnedException;

	public Assignment createAssignment(Integer courseId, Assignment assignment);

	public File createSuppliedFile(Integer assignmentId, MultipartFile file, String username) throws IncorrectFileNameFormatException, FileUploadException, HashingException, NoResultsReturnedException, TooManyResultsReturnedException;
}
