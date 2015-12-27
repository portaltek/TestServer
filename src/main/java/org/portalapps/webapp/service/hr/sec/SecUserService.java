package org.portalapps.webapp.service.hr.sec;

import javax.annotation.Resource;

import org.portalapps.webapp.dao.sec.SecUserDao;
import org.portalapps.webapp.dto.sec.SecUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("secUserService")
@Transactional("secEntityTransactionManager")
public class SecUserService {
    
	@Resource(name="secUserDao") 
	private SecUserDao dao;
	
	@Resource 
	private PasswordEncoder passwordEncoder;
 
    public SecUser findById(String id) {
        return dao.findById(id);
    }
    
    
    public void insert(SecUser user) throws Exception{
    	String p = passwordEncoder.encode(user.getPassword());
        user.setPassword(p); 
        user.setStateId("ACT");
        dao.insert(user);
    }

   
}