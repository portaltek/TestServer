package org.portalapps.webapp.service.hr.sec;

import javax.annotation.Resource;

import org.portalapps.webapp.dao.sec.SecSystemDao;
import org.portalapps.webapp.dto.sec.SecSystem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional("secEntityTransactionManager")
public class SecSystemService {
    
	@Resource
	private SecSystemDao dao;
	
    public SecSystem findById(String id) {
        return dao.findById(id);
    }
    
    

   
}