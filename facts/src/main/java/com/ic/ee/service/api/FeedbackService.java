package com.ic.ee.service.api;

import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.feedback.comment.Comment;
import com.ic.ee.domain.common.feedback.mark.Mark;

public interface FeedbackService {

	public Feedback getLiteFeedback(Integer feedbackId);

	public Comment getLiteComment(Integer commentId);

	public Mark getLiteMark(Integer markId);

	public Feedback getSubmissionFeedback(Integer submissionId);

	public Feedback createFeedback(Integer submissionId, String username);

	public Feedback getFeedback(Integer feedbackId);

}
