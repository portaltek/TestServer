package org.portalapps.webapp.config;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public abstract class AppDataSource extends AppConfig {

	protected String driverClassName;
	protected String url;
	protected String username;
	protected String password;

	protected DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(prop.getProp(driverClassName));
		ds.setUrl(prop.getProp(url));
		ds.setUsername(prop.getProp(username));
		ds.setPassword(prop.getProp(password));
		return ds;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
