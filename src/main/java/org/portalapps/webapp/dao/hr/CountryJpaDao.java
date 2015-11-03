package org.portalapps.webapp.dao.hr;

import org.portalapps.webapp.dao.AbstracJpaDao;
import org.portalapps.webapp.dto.hr.Country;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CountryJpaDao extends AbstracJpaDao<Country, String> {

	
	
}
