package com.ic.ee.service.api;

import java.util.List;

import com.ic.ee.domain.common.feedback.mark.MarkComponent;

public interface MarkComponentService {

	public List<MarkComponent> createMarkComponents(Integer assignmentId, List<MarkComponent> markComponents);
}
