package org.portalapps.webapp.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
		"org.portalapps.webapp.dto",
		"org.portalapps.webapp.dao", 
		"org.portalapps.webapp.service",
		
		"org.portalapps.webapp.controller",
		"org.portalapps.webapp.config"
})
@Import({
	ConfigHr.class
	})
public class AppControllerConfig extends WebMvcConfigurerAdapter{
	
	@Autowired protected  Prop prop;
	
//	public static final String PREFIX_RESOLVER = "/WEB-INF/views/";
	public static final String PREFIX_RESOLVER = "/views/";
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
		registry.addResourceHandler("/resources/**")
		.addResourceLocations("/resources/");
//		.setCachePeriod(31556926);
	}

	
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
    


}