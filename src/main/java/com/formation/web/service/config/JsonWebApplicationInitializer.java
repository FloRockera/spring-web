package com.formation.web.service.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class JsonWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return //ServiceConfig;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return "service/*";
	}

}
