package org.portalapps.webapp.config.impl;

import javax.persistence.EntityManagerFactory;

import org.portalapps.webapp.config.ConfigJpaHibernate;
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
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = {
		"org.portalapps.webapp.dao.sec"
})
public class ConfigSec extends ConfigJpaHibernate {

	{
		driver 		= "javax.persistence.jdbc.sec.driver";
		url 		= "javax.persistence.jdbc.sec.url";
		user 		= "javax.persistence.jdbc.sec.user";
		password 	= "javax.persistence.jdbc.sec.password";


		hibernateDialect				= "hibernate.sec.dialect";
		hibernateShowSql				= "hibernate.sec.show_sql";
		hibernateHbm2ddlAuto			= "hibernate.sec.hbm2ddl.auto";
		hibernatePackagesToScan 		= "hibernate.sec.packagesToScan";
		hibernatePersistenceUnitName 	= "hibernate.sec.persistenceUnitName";
	}

	@Bean(name="secEntityManagerFactory")    
	public LocalContainerEntityManagerFactoryBean secEntityManagerFactory()	{
		return super.entityManagerFactory();
	}

	@Bean(name="secEntityTransactionManager")   
	public JpaTransactionManager secEntityTransactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		EntityManagerFactory emf = secEntityManagerFactory().getObject();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
	
}