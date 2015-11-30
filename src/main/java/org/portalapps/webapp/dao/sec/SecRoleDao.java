package org.portalapps.webapp.dao.sec;

import org.portalapps.webapp.dao.JpaHibernateSecDao;
import org.portalapps.webapp.dto.sec.SecRole;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("secEntityTransactionManager")
public class SecRoleDao extends JpaHibernateSecDao<SecRole, String>  {



}
