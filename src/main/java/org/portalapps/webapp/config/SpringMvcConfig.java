package org.portalapps.webapp.config;

import org.portalapps.webapp.config.impl.ConfigHr;
import org.portalapps.webapp.config.impl.ConfigSec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
		// "org.portalapps.webapp.dto",
		"org.portalapps.webapp.dao", "org.portalapps.webapp.service",

		"org.portalapps.webapp.controller", "org.portalapps.webapp.config" })
@Import({ ConfigHr.class, ConfigSec.class,
		// ConfigSecurity.class,
})
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	protected Prop prop;

	public static final String PREFIX_RESOLVER = "/WEB-INF/views/";
	// public static final String PREFIX_RESOLVER = "/views/";
	public static final String SUFIX_RESOLVER = ".jsp";

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix(PREFIX_RESOLVER);
		resolver.setSuffix(SUFIX_RESOLVER);
		resolver.setViewClass(JstlView.class);
//		resolver.setViewClass(TilesView.class);
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		// .setCachePeriod(31556926);
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

//	@Bean
//	public TilesViewResolver getTilesViewResolver() {
//		TilesViewResolver tilesViewResolver = new TilesViewResolver();
//		tilesViewResolver.setPrefix(PREFIX_RESOLVER);
//		tilesViewResolver.setSuffix(SUFIX_RESOLVER);
//		tilesViewResolver.setViewClass(TilesView.class);
//		return tilesViewResolver;
//	}
	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//		resolver.setPrefix(PREFIX_RESOLVER);
//		resolver.setSuffix(SUFIX_RESOLVER);
		resolver.setViewClass(TilesView.class);
		return resolver;
	}
	

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] { "/resources/tiles/tiles-definitions.xml" });
//		tilesConfigurer.setCheckRefresh(true);
//		tilesConfigurer.setUseMutableTilesContainer(true);
		
		return tilesConfigurer;
	}

}