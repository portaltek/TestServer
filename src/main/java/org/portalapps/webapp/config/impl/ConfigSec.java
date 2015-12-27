package org.portalapps.webapp.config.impl;

import org.portalapps.webapp.config.AppEntityManagerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableCaching
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
		"org.portalapps.webapp.dao.sec"
})
public class ConfigSec extends AppEntityManagerFactory {
	
	{
		driverClassName = "sec.jdbc.driverClassName";
		url 			= "sec.jdbc.url";
		username 		= "sec.jdbc.username";
		password 		= "sec.jdbc.password";
		
		hibernateDialect 				= "sec.hibernate.dialect";
		hibernateShowSql 				= "sec.hibernate.show_sql";
//		hibernateHbm2ddlAuto 			= "sec.hibernate.hbm2ddl.auto";
		hibernatePackagesToScan 		= "sec.hibernate.packagesToScan";
		hibernatePersistenceUnitName 	= "sec.hibernate.persistenceUnitName";
		hibernateEnableLazyLoadNoTrans 	= "sec.hibernate.enableLazyLoadNoTrans";
	}


	@Bean(name="secEntityManagerFactory")    
	public LocalContainerEntityManagerFactoryBean secEntityManagerFactory()	{
		return super.getEntityManagerFactory();
	}

	@Bean(name="secEntityTransactionManager")   
	public JpaTransactionManager secEntityTransactionManager(){
		return getTransactionManager(secEntityManagerFactory().getObject());
	}


	
}