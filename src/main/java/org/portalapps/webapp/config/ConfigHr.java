package org.portalapps.webapp.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@EnableAspectJAutoProxy
@EnableCaching
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
		"org.portalapps.webapp"
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

	@Bean(name="hrEntityManagerFactory")    
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()	{
		return super.entityManagerFactory();
	}



	//	@Bean
	//	public PlatformTransactionManager transactionManager(){
	//		JpaTransactionManager transactionManager = new JpaTransactionManager();
	//		transactionManager.setEntityManagerFactory(
	//				super.entityManagerFactory().getObject() );
	//		return transactionManager;
	//	}	

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
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
	
	//	@Bean
	//	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	//		return new PersistenceExceptionTranslationPostProcessor();
	//	}	

}