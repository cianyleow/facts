package com.ic.ee.service.api;

import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;
import com.ic.ee.domain.common.feedback.Feedback;

public interface FeedbackService {

	public Feedback getSubmissionFeedback(Integer submissionId);

	public Feedback createFeedback(Integer submissionId, String username) throws NoResultsReturnedException, TooManyResultsReturnedException;

}
