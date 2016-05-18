package com.ic.ee.util.collection;

public interface Extractor<T1, T2> {

	public T2 extract(T1 element);

}
