package org.portalapps.webapp.config;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public abstract class ConfigJpa extends Config {

	protected String driver ;
	protected String url ;
	protected String user ;
	protected String password ;
	 
	protected DataSource getDataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();        
		ds.setDriverClassName(prop.getProp(driver));
		ds.setUrl(prop.getProp(url));
		ds.setUsername(prop.getProp(user));
		ds.setPassword(prop.getProp(password));        
		return ds;
	}
}
