package com.shiva.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan
public class MvcConfig {
	@Bean
	public ViewResolver beanNameViewResolver() {
		return new BeanNameViewResolver();
	}
}
