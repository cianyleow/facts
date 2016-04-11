package com.ic.ee.util;

public interface Matcher<T, T1, T2> {

	public boolean check(T1 elementOne, T2 elementTwo);

	public T remove(T1 elementOne, T2 elementTwo);
}
