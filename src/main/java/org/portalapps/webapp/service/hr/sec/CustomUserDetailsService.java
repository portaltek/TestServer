package org.portalapps.webapp.service.hr.sec;

import java.util.ArrayList;
import java.util.List;

//import org.portalapps.webapp.dto.sec.SecRol;
//import org.portalapps.webapp.dto.sec.SecUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
 
//    @Autowired
//    private SecUserService userService;
     
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String id)
            throws UsernameNotFoundException {
    	return null;
//        SecUser user = userService.findById(id);
//        System.out.println("User : "+user);
//        if(user==null){
//            System.out.println("User not found");
//            throw new UsernameNotFoundException("Username not found");
//        }
//            return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(), 
//                 user.getStateId().equals("ACT"), true, true, true, getGrantedAuthorities(user));
    }
 
     
//    private List<GrantedAuthority> getGrantedAuthorities(SecUser user){
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//         
//        for(SecRol secRol : user.getUserRolList()){
//            System.out.println("UserProfile : "+secRol);
//            String rol = "ROLE_" + secRol.getRolName();
//            authorities.add(new SimpleGrantedAuthority(rol));
//        }
//        System.out.print("authorities :"+authorities);
//        return authorities;
//    	return null
//    }
     
}