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
import org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory;
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
public class ConfigWebMvc extends WebMvcConfigurerAdapter {

	@Autowired
	protected Prop prop;

	public static final String PREFIX_RESOLVER = "/WEB-INF/views/";
	// public static final String PREFIX_RESOLVER = "/views/";
	public static final String SUFIX_RESOLVER = ".jsp";

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix(PREFIX_RESOLVER);
		viewResolver.setSuffix(SUFIX_RESOLVER);
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
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

	// @Bean
	// public UrlBasedViewResolver viewResolver() {
	// UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
	// viewResolver.setViewClass(TilesView.class);
	// return viewResolver;
	// }

	// @Bean
	// public TilesConfigurer tilesConfigurer() {
	// TilesConfigurer c = new TilesConfigurer();
	// c.setDefinitions("/WEB-INF/layouts/layouts.xml",
	// "/WEB-INF/layouts/views.xml");
	//// c.setCheckRefresh(true);
	// c.setPreparerFactoryClass(SpringBeanPreparerFactory.class);
	// return new TilesConfigurer();
	// }

	@Bean
	TilesViewResolver viewResolver() {
		TilesViewResolver viewResolver = new TilesViewResolver();
		return viewResolver;
	}

	@Bean
	TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
//		tilesConfigurer.setDefinitions("WEB-INF/tiles/tiles.xml", "WEB-INF/tiles/products.xml");
		tilesConfigurer.setDefinitions("WEB-INF/tiles/tiles.xml");
		tilesConfigurer
				.setPreparerFactoryClass(org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory.class);
		return tilesConfigurer;
	}
}