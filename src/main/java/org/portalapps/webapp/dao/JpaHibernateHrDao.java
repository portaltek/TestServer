package org.portalapps.webapp.dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public abstract class JpaHibernateHrDao<E, ID> extends JpaHibernate<E, ID>{

	@PersistenceContext(unitName = "hrPU")
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
}
