package org.portalapps.webapp.dao.hr;

import org.portalapps.webapp.dao.AbstracJpaDao;
import org.portalapps.webapp.dto.hr.Region;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RegionJpaDao extends AbstracJpaDao<Region, Integer>  {



}
