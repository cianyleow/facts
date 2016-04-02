package com.ic.ee.service.api;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.feedback.mark.MarkComponent;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.common.file.FileRequirement;
import com.ic.ee.domain.course.assignment.Assignment;

public interface AssignmentService {

	public Assignment getAssignment(Integer assignmentId) throws NoResultsReturnedException, TooManyResultsReturnedException;

	public List<Assignment> getAssignments(Integer courseId);

	public List<FileRequirement> getRequiredFiles(Integer assignmentId);

	public List<MarkComponent> getMarkComponents(Integer assignmentId);

	public List<File> getSuppliedFiles(Integer assignmentId);

	public Assignment createAssignment(Integer courseId, Assignment assignment);

	public File createSuppliedFile(Integer assignmentId, MultipartFile file, String username) throws IncorrectFileNameFormatException, FileUploadException, HashingException;
}
