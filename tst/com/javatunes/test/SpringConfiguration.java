package com.javatunes.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.javatunes.bean.Cart;
import com.javatunes.bean.Catalog;
import com.javatunes.bean.JavaTunesCatalog;

@Configuration
public class SpringConfiguration {
	
	private static final String PROTOTYPE = "prototype";
	
	@Bean
	@Scope(PROTOTYPE)
	public Catalog catalog() {
		return new JavaTunesCatalog();
	}
	
	@Bean
	@Scope(PROTOTYPE)
	public Cart cart() {
		return new Cart("a", "1:1,2:2,3:3");
	}
}