package org.portalapps.webapp.dao.hr;

import org.portalapps.webapp.dao.JpaHibernateHrDao;
import org.portalapps.webapp.dto.hr.Country;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CountryJpaDao extends JpaHibernateHrDao<Country, String> {

	
	
}
