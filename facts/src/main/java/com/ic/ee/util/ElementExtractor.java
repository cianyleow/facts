package com.ic.ee.util;

import java.util.List;

import com.ic.ee.core.web.exception.NoResultsReturnedException;
import com.ic.ee.core.web.exception.TooManyResultsReturnedException;

public class ElementExtractor {

	public static <T> T extractOne(List<T> elements) throws NoResultsReturnedException, TooManyResultsReturnedException {
		if(elements == null) {
			throw new NoResultsReturnedException();
		} else if(elements.isEmpty()) {
			throw new NoResultsReturnedException();
		} else if(elements.size() > 1) {
			throw new TooManyResultsReturnedException();
		}
		return elements.get(0);
	}
}
