package org.portalapps.webapp.dao;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;


public class  AbstracEjbDao<E, ID>  implements IDao<E, ID>{
	@PersistenceContext(unitName = "hrPU")
	protected EntityManager em;
	protected Class<E> clazz;

	@SuppressWarnings("unchecked")
	@PostConstruct
	private void setClass() throws Exception{
		try {
			ParameterizedType p= (ParameterizedType) getClass().getGenericSuperclass();
			Class<E> clazz = (Class<E>) p.getActualTypeArguments()[0];
			this.clazz = clazz;
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void printHello() {
		System.out.println("AbstracDao<=" + clazz + "Dao");
	}

	public void insert(E e) {
		printHello();
		
	}

	public void update(E e) {
		printHello();
		
	}

	public void delete(E e) {
		printHello();
		
	}

	public E findById(ID id) {
		printHello();
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		printHello();
		String q = "from " + clazz.getName();
		List<E> resultList = em
				.createQuery(q)
				.getResultList();
		return resultList;	

	}
	
	@SuppressWarnings("unchecked")
	public static <T> T initializeAndUnproxy(T entity) {
	   Hibernate.initialize(entity);
	   if (entity instanceof HibernateProxy) 
		   entity = (T) ((HibernateProxy) entity)
		   .getHibernateLazyInitializer()
		   .getImplementation();
	   return entity;
	}
//	@SuppressWarnings("unchecked")
//	public Regions find(Regions e) {
//		printHello();
//		String q = "from " + clazz.getName();
////		List<E> rs = em.createQuery(q)
////				.getResultList();
//		boolean isInit = Hibernate.isInitialized(e);
//		System.out.println("isInit: "+isInit);
//		Hibernate.initialize(e.getCountriesList());
//		
//		return e;		
//	}
	
	
}
