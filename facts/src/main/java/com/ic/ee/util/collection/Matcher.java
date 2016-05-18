package com.ic.ee.util.collection;

public interface Matcher<T1, T2> {

	public boolean matches(T1 elementOne, T2 elementTwo);

}
