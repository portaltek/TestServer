package org.portalapps.webapp.dao.sec;

import org.portalapps.webapp.dao.JpaHibernateSecDao;
import org.portalapps.webapp.dto.sec.SecSystem;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("secEntityTransactionManager")
public class SecSystemDao extends JpaHibernateSecDao<SecSystem, String>  {



}
