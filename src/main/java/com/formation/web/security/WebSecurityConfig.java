package com.formation.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/humancontact/**").authenticated().antMatchers("/humancontact/home")
				.permitAll().antMatchers("/humancontact/admin").hasAnyRole("ADMIN").antMatchers("/humancontact/user")
				.hasAnyRole("user").and().formLogin().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/humancontact/logout"));
		// .logoutSuccessUrl(("/humancontact/"));
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		UserBuilder builder = User.withDefaultPasswordEncoder();

		UserDetailsManager userDetailManager = new InMemoryUserDetailsManager();
		userDetailManager.createUser(builder.username("admin").password("admin").roles("ADMIN", "USER").build());
		userDetailManager.createUser(builder.username("user").password("user").roles("USER").build());
		return userDetailManager;
	}

}
