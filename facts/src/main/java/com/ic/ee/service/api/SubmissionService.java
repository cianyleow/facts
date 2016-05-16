package com.ic.ee.service.api;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ic.ee.core.web.exception.FileUploadException;
import com.ic.ee.core.web.exception.HashingException;
import com.ic.ee.core.web.exception.IncorrectFileNameFormatException;
import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.SubmissionFileMatchException;
import com.ic.ee.core.web.exception.SubmissionFileValidationException;
import com.ic.ee.core.web.exception.UnmatchableSetsException;
import com.ic.ee.domain.course.assignment.submission.Submission;

public interface SubmissionService {
	public Submission getSubmission(Integer submissionId);

	public Submission getLiteSubmission(Integer submissionId);

	public Submission createSubmission(Integer assignmentId, Submission submission, MultipartFile[] files, String username) throws NoResultsReturnedException, SubmissionFileMatchException, UnmatchableSetsException, SubmissionFileValidationException, IncorrectFileNameFormatException, FileUploadException, HashingException;

	public List<Submission> getSubmissions(Integer assignmentId, String username);

}
