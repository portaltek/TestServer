package org.portalapps.webapp.config.impl;

import javax.persistence.EntityManagerFactory;

import org.portalapps.webapp.config.ConfigJpaHibernate;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
public class ConfigHr extends ConfigJpaHibernate {

	{
		driver 		= "javax.persistence.jdbc.hr.driver";
		url 		= "javax.persistence.jdbc.hr.url";
		user 		= "javax.persistence.jdbc.hr.user";
		password 	= "javax.persistence.jdbc.hr.password";


		hibernateDialect				= "hibernate.hr.dialect";
		hibernateShowSql				= "hibernate.hr.show_sql";
		hibernateHbm2ddlAuto			= "hibernate.hr.hbm2ddl.auto";
		hibernatePackagesToScan 		= "hibernate.hr.packagesToScan";
		hibernatePersistenceUnitName 	= "hibernate.hr.persistenceUnitName";
	}

	@Primary
	@Bean(name="hrEntityManagerFactory")    
	public LocalContainerEntityManagerFactoryBean hrEntityManagerFactory()	{
		return super.entityManagerFactory();
	}

	@Bean(name="hrEntityTransactionManager")   
	public JpaTransactionManager hrEntityTransactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		EntityManagerFactory emf = hrEntityManagerFactory().getObject();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
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