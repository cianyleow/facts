package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.common.feedback.Feedback;
import com.ic.ee.domain.common.feedback.mark.Mark;

public interface MarkDAO extends BaseDAO<Mark, Integer> {

	public List<Mark> getMarks(Feedback feedback);

}
