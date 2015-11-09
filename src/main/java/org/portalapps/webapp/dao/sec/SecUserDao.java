package org.portalapps.webapp.dao.sec;

import org.portalapps.webapp.dao.JpaHibernateSecDao;
import org.portalapps.webapp.dto.sec.SecUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("secEntityTransactionManager")
public class SecUserDao extends JpaHibernateSecDao<SecUser, String>  {



}
