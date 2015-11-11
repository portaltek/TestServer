package org.portalapps.webapp.dao.hr;

import org.portalapps.webapp.dao.JpaHibernateHrDao;
import org.portalapps.webapp.dto.hr.Region;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("hrEntityTransactionManager")
public class RegionJpaDao extends JpaHibernateHrDao<Region, Integer>  {



}
