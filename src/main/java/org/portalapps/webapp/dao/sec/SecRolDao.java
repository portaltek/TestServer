package org.portalapps.webapp.dao.sec;

import org.portalapps.webapp.dao.JpaHibernateSecDao;
import org.portalapps.webapp.dto.sec.SecRol;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SecRolDao extends JpaHibernateSecDao<SecRol, String>  {



}
