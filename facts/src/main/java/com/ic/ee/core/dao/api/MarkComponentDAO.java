package com.ic.ee.core.dao.api;

import java.util.List;

import com.ic.ee.core.dao.BaseDAO;
import com.ic.ee.domain.common.feedback.mark.MarkComponent;

public interface MarkComponentDAO extends BaseDAO<MarkComponent, Integer> {

	public List<MarkComponent> getMarkComponents(Integer assignmentId);
}
