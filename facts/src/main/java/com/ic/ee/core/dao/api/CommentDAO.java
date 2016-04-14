package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.feedback.comment.Comment;

public interface CommentDAO extends BaseDAO<Comment, Integer> {

	public List<Comment> getComments(Feedback feedback);

}
