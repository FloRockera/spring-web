package com.web.initialiser;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public interface WebApplicationInitialiser {

	public void onStartUp(ServletContext servletContext) throws ServletException;

}
