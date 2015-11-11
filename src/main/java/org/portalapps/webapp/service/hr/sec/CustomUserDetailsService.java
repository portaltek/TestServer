package org.portalapps.webapp.service.hr.sec;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.portalapps.webapp.dto.sec.SecRol;
import org.portalapps.webapp.dto.sec.SecUser;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	@Resource(name="secUserService")
	private SecUserService dao;	

	public UserDetails loadUserByUsername(String id)
			throws UsernameNotFoundException {
		try {
			SecUser user = dao.findById(id);
//			System.out.println(user);
			if(user==null){
//				System.out.println("User not found");
				throw new UsernameNotFoundException("Username not found");
			}
			return new User(user.getUserId(), user.getPassword(), 
					user.getStateId().equals("ACT"), true, true, true, getGrantedAuthorities(user));
		} catch (Exception e) {
			throw new InternalAuthenticationServiceException(e.getMessage() , e);
		}

	}


	private List<GrantedAuthority> getGrantedAuthorities(SecUser user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for(SecRol secRol : user.getUserRolList()){
			String rol =  secRol.getRolName(); //"ROLE_" +
			authorities.add(new SimpleGrantedAuthority(rol));
		}
//		System.out.println("authorities :"+authorities.toString());
		return authorities;
	}

}