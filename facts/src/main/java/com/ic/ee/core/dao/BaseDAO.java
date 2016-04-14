package com.ic.ee.core.dao;

import java.util.List;

public interface BaseDAO<T, T1> {
	public T one(T1 id);

	public List<T> several(List<T1> ids);

	public T create(T newObject);

	public T update(T updateObject);

	public boolean delete(T1 id);

}
