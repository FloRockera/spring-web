package com.formation.web.initialiser;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class ViewWebApplicationInitialiser implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(ViewConfig.class);

		servletContext.addListener(new ContextLoaderListener(webContext));

		// Create and register the DispatcherServlet
		DispatcherServlet servlet = new DispatcherServlet(webContext);
		ServletRegistration.Dynamic registration = servletContext.addServlet("view", servlet);
		registration.setLoadOnStartup(1);
		// Le chemin du servletContext est /humancontact
		registration.addMapping("/humancontact/*");

		FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("utf8­encoding",
				new CharacterEncodingFilter("UTF-8", true));

		encodingFilter.addMappingForUrlPatterns(null, false, "/*");

	}

}
