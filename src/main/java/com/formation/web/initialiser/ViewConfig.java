package com.formation.web.initialiser;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.formation.AppConfigMess;
import com.formation.web.controller.HelloController;
import com.formation.web.security.WebSecurityConfig;

@Configuration
@EnableWebMvc
@Import({ AppConfigMess.class, WebSecurityConfig.class })
@ComponentScan(basePackageClasses = { HelloController.class })
public class ViewConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	// Pour permettre d'exposer le css dans le dossier resources.
	// Ajouter dans le jsp c:url
	public void addRessourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources");
	}

}
