package com.web.initialiser;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.formation.AppConfigMess;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = AppConfigMess.class)
public class ViewConfig implements WebMvcConfigurer {

}
