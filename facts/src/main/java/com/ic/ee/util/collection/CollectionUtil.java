package com.ic.ee.util.collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtil {

	public static <T1, T2> List<T2> extractAttribute(List<T1> elements, Extractor<T1, T2> extractor) {
		ArrayList<T2> attributes = new ArrayList<T2>();
		for(T1 element : elements) {
			attributes.add(extractor.extract(element));
		}
		return attributes;
	}

	public static <T1, T2> List<T1> matchSets(List<T1> elements, List<T2> attributes, Matcher<T1, T2> matcher, Setter<T1, T2> setter) {
		for(T1 element : elements) {
			for(T2 attribute : attributes) {
				if(matcher.matches(element, attribute)) {
					setter.set(element, attribute);
					break;
				}
			}
		}
		return elements;
	}


}
