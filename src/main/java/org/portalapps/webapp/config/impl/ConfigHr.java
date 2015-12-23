package org.portalapps.webapp.config.impl;

import org.portalapps.webapp.config.AppEntityManagerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableCaching
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = {
		"org.portalapps.webapp.dao.hr"
		})
public class ConfigHr extends AppEntityManagerFactory {

	{
		driverClassName = "hr.jdbc.driverClassName";
		url 			= "hr.jdbc.url";
		username 		= "hr.jdbc.username";
		password 		= "hr.jdbc.password";
		
		hibernateDialect 				= "hr.hibernate.dialect";
		hibernateShowSql 				= "hr.jdbc.url";
//		hibernateHbm2ddlAuto 			= "hr.hibernate.hbm2ddl.auto";
		hibernatePackagesToScan 		= "hr.hibernate.packagesToScan";
		hibernatePersistenceUnitName 	= "hr.hibernate.persistenceUnitName";
		hibernateEnableLazyLoadNoTrans 	= "hr.hibernate.enableLazyLoadNoTrans";
	}

	@Bean(name="hrEntityManagerFactory")    
	public LocalContainerEntityManagerFactoryBean hrEntityManagerFactory()	{
		return super.getEntityManagerFactory();
	}

	@Bean(name="hrEntityTransactionManager")   
	public JpaTransactionManager hrEntityTransactionManager(){
		return getTransactionManager(hrEntityManagerFactory().getObject());
	}

	@Bean 
	public CacheManager cacheManager() { 
		return new ConcurrentMapCacheManager();
	} 
	@Bean 
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator(); 
	} 


}