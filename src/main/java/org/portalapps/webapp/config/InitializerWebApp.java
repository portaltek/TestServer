package org.portalapps.webapp.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class InitializerWebApp extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SpringMvcConfig.class };
		// return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {
				// ConfigWebMvc.class
		};
		// return null;
	}

	@Override
	protected String[] getServletMappings() {
		// return new String[] {"*.jsp"};
		return new String[] { "/" };
	}



}