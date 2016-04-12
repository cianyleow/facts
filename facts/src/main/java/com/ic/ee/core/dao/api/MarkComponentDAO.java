package com.ic.ee.core.dao.api;

import com.ic.ee.domain.common.feedback.mark.MarkComponent;

public interface MarkComponentDAO {

	public Integer createMarkComponent(Integer assignmentId, MarkComponent markComponent);
}
