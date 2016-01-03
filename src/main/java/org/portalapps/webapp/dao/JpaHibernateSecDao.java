package org.portalapps.webapp.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.transaction.annotation.Transactional;

@Transactional("secEntityTransactionManager")
public abstract class JpaHibernateSecDao<E, ID> {

	@PersistenceContext(unitName = "secPU")
	protected EntityManager em;

	protected Class<E> clazz;

	public enum ACTION {
		SELECT, INSERT, UPDATE, DELETE
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	private void setClass() throws Exception {
		try {
			ParameterizedType p = (ParameterizedType) getClass().getGenericSuperclass();
			Class<E> clazz = (Class<E>) p.getActualTypeArguments()[0];
			this.clazz = clazz;

		} catch (Exception e) {
			throw e;
		}
	}

	public void insert(E e) throws Exception {

		em.persist(e);

	}

	public boolean exist(ID id) {
		return findById(id)!=null;
	}

	@SuppressWarnings("unchecked")
	public List<E> executetQuery(String queryString) {
		Query query = em.createQuery(queryString);
		List<E> resultList = (List<E>) query.getResultList();
		return resultList;
	}

	public int executeUpdate(String updateString) {
		return em.createQuery(updateString).executeUpdate();
	}

	public void update(E e) throws Exception {
		em.merge(e);
	}

	public void delete(E e) throws Exception {
		em.remove(em.merge(e));
	}

	public E findById(ID id) {
		return em.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		String q = "from " + clazz.getName();
		List<E> resultList = em.createQuery(q).getResultList();
		return resultList;

	}

	@SuppressWarnings("unchecked")
	public static <T> T initializeAndUnproxy(T entity) {
		Hibernate.initialize(entity);
		if (entity instanceof HibernateProxy)
			entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer().getImplementation();
		return entity;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
