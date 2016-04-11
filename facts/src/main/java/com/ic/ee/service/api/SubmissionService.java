package com.ic.ee.service.api;

import org.springframework.web.multipart.MultipartFile;

import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.SubmissionFileValidationException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.file.File;
import com.ic.ee.domain.course.assignment.submission.Submission;

public interface SubmissionService {

	public Submission createSubmission(Integer assignmentId, Submission submission, String username) throws NoResultsReturnedException, TooManyResultsReturnedException;

	public Submission validateSubmission(Integer submissionId, Submission submission);

	public File createSubmissionFile(Integer submissionId, Integer fileRequirementId, MultipartFile file, String username) throws IncorrectFileNameFormatException, FileUploadException, HashingException, SubmissionFileValidationException, NoResultsReturnedException, TooManyResultsReturnedException;

	public Submission getSubmission(Integer submissionId) throws NoResultsReturnedException, TooManyResultsReturnedException;


}
