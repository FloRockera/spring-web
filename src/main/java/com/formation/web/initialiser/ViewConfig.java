package com.formation.web.initialiser;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.formation.web.controller.HelloController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = HelloController.class)
public class ViewConfig implements WebMvcConfigurer {

}
