package org.portalapps.webapp.dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public abstract class JpaHibernateSecDao<E, ID> extends JpaHibernate<E, ID>{

	@PersistenceContext(unitName = "secPU")
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
}
