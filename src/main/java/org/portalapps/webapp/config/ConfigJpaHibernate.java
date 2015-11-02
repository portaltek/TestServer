package org.portalapps.webapp.config;

import java.util.Properties;

import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

public abstract class ConfigJpaHibernate extends ConfigJpa {
	
	protected String hibernateDialect;
	protected String hibernateShowSql;
	protected String hibernateHbm2ddlAuto;
	protected String hibernatePackagesToScan;
	protected String hibernatePersistenceUnitName;
	protected String hibernateEnableLazyLoadNoTrans;
	

	public Properties getHibernateProperties(){

		Properties properties = new Properties();
		properties.put("hibernate.dialect", prop.getProp(hibernateDialect));
		properties.put("hibernate.show_sql", prop.getProp(hibernateShowSql));
		properties.put("hibernate.hbm2ddl.auto", prop.getProp(hibernateHbm2ddlAuto));
//		properties.put("hibernate.enable_lazy_load_no_trans", prop.getProp(hibernateEnableLazyLoadNoTrans));
		

		return properties;
	}	
	

	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setDataSource(getDataSource());
		em.setPackagesToScan(prop.getProp(hibernatePackagesToScan));
		em.setPersistenceUnitName(prop.getProp(hibernatePersistenceUnitName));		
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(getHibernateProperties());

		return em;
	}	
	

}
