package org.portalapps.webapp.dao;

import java.util.List;


public interface IDao<E, ID> {
	void insert(E e);
	void update(E e);
	void delete(E e);
	E findById(ID id);
	List<E> findAll();
}
