package org.portalapps.webapp.config;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Prop {

	private Properties prop ;
	private Properties envProp ;
	private PropertiesFactoryBean pfb = new PropertiesFactoryBean();
	public final String ENV_FILE = "webapp.env.properties";
	public final String ENV_FILE_PROP = "webapp.env.properties.file";
	public final String ENV_PROP = "webapp.current.env";
	
	@PostConstruct
	public void initEnvProp()   {
		try {
			pfb.setLocation(new ClassPathResource(ENV_FILE));
			pfb.afterPropertiesSet();
			envProp=(Properties)pfb.getObject();
//			System.out.println(envProp.getProperty(ENV_FILE_PROP));
//			System.out.println(envProp.getProperty(ENV_FILE_PROP));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@PostConstruct
	public void initProp()   {
		try {
			String propFile = envProp.getProperty(ENV_FILE_PROP);
			pfb.setLocation(new ClassPathResource(propFile));
			pfb.afterPropertiesSet();
		    prop=(Properties)pfb.getObject();
//			System.out.println(prop.getProperty("javax.persistence.jdbc.hr.url"));
//			System.out.println(prop.getProperty("javax.persistence.jdbc.hr.user"));
//		
		}catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	



	public String getProp(String prop) {
		return this.prop.getProperty(prop);
	}

	public String getEnv() {
		return getProp(ENV_PROP);
	}
	
	
}
