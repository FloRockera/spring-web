package com.formation.web.initialiser;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.formation.AppConfigMess;
import com.formation.web.controller.HelloController;

@Configuration
@EnableWebMvc
@Import({ AppConfigMess.class })
@ComponentScan(basePackageClasses = { HelloController.class })
public class ViewConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

}
