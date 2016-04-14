package com.ic.ee.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ic.ee.core.dao.api.MarkComponentDAO;
import com.ic.ee.domain.common.feedback.mark.MarkComponent;
import com.ic.ee.service.api.MarkComponentService;

public class SimpleMarkComponentService implements MarkComponentService {

	private final MarkComponentDAO markComponentDAO;

	public SimpleMarkComponentService(MarkComponentDAO markComponentDAO) {
		this.markComponentDAO = markComponentDAO;
	}

	@Override
	public List<MarkComponent> createMarkComponents(Integer assignmentId, List<MarkComponent> markComponents) {
		List<MarkComponent> addedMarkComponents = new ArrayList<MarkComponent>();
		for(MarkComponent markComponent : markComponents) {
			addedMarkComponents.add(createMarkComponent(assignmentId, markComponent));
		}
		return addedMarkComponents;
	}

	public MarkComponent createMarkComponent(Integer assignmentId, MarkComponent markComponent) {
		return markComponentDAO.create(markComponent);
	}

}
