package org.portalapps.webapp.dao.sec;

import org.portalapps.webapp.dao.JpaHibernateSecDao;
import org.portalapps.webapp.dto.sec.Prueba;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("secEntityTransactionManager")
public class PruebaDao extends JpaHibernateSecDao<Prueba, String>  {


	public void insert(Prueba e) {
		em.persist(e);		
	}

}
