package org.portalapps.webapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


public interface IDao<E> {
	void insert(E e);
	void update(E e);
	void delete(E e);
	E findBy(E e);
	List<E> findAll();
}
