package org.portalapps.webapp.service.hr.sec;

import org.portalapps.webapp.dao.sec.SecUserDao;
import org.portalapps.webapp.dto.sec.SecUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("secUserService")

public class SecUserService {
    
	@Autowired private SecUserDao dao;
    @Autowired private PasswordEncoder passwordEncoder;
 
    public SecUser findById(String id) {
        return dao.findById(id);
    }
    
    @Transactional("secEntityTransactionManager")
    public void insert(SecUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.insert(user);
    }

   
}