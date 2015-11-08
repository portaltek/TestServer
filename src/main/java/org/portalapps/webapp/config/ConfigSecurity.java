package org.portalapps.webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration

@EnableWebSecurity
//public class ConfigSecurity extends WebSecurityConfigurerAdapter  {
//extends AbstractSecurityWebApplicationInitializer
public class ConfigSecurity extends WebSecurityConfigurerAdapter  {
	@Autowired
	CustomSuccessHandler customSuccessHandler;

//	@Autowired
//	@Qualifier("customUserDetailsService")
//	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin").password("admin").roles("ADMIN")
		;
//		auth.userDetailsService(userDetailsService);
	}

	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
	//.csrf() is optional, enabled by default, if using WebSecurityConfigurerAdapter constructor
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/login**").permitAll()
		.antMatchers("/user**", "/").access("hasRole('ROLE_USER')")
		.antMatchers("/admin**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/dba**").access("hasRole('ROLE_DBA')")


		.and()
		.formLogin().loginPage("/login").successHandler(customSuccessHandler)
		.usernameParameter("j_username").passwordParameter("j_password")

		.and()
		.exceptionHandling().accessDeniedPage("/accessDenied")

		.and()
		.logout().logoutSuccessUrl("/login?logout")

		//		.and()
		//		    .formLogin()
		//		    	.loginPage("/login").defaultSuccessUrl("/admin").failureUrl("/login?error")
		//		    	.loginProcessingUrl( "/j_spring_security_check" )
		//		    	.usernameParameter("username").passwordParameter("password")		


		; 		
	}
}
