package org.portalapps.webapp.service.hr.sec;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.portalapps.webapp.dto.sec.CustomUser;
import org.portalapps.webapp.dto.sec.SecRole;
import org.portalapps.webapp.dto.sec.SecUser;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
			if(user==null){
				throw new UsernameNotFoundException("Username not found");
			}
			
			CustomUser u=new CustomUser(
					user.getUserId(), user.getPassword(), 
					user.getStateId().equals("ACT"),
					true, true, true,
					getGrantedAuthorities(user));
			
			List<String> urlList = new ArrayList<>();
			urlList.add("/mantto/secSystem/");
			urlList.add("/main");
			urlList.add("/admin");
			urlList.add("/admin/main");
			urlList.add("/user");
			urlList.add("/user/main");
			urlList.add("/dba");
			urlList.add("/dba/main");
			urlList.add("/opcion");
			urlList.add("/opcion/main");
			urlList.add("/opcion/main");
						
			u.setUrlList(urlList);
			return u;
		} catch (Exception e) {
			throw new InternalAuthenticationServiceException(e.getMessage() , e);
		}

	}


	private List<GrantedAuthority> getGrantedAuthorities(SecUser user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for(SecRole secRol : user.getUserRoleList()){
			String rol =  secRol.getName(); //"ROLE_" +
			authorities.add(new SimpleGrantedAuthority(rol));
		}
//		System.out.println("authorities :"+authorities.toString());
		return authorities;
	}

}