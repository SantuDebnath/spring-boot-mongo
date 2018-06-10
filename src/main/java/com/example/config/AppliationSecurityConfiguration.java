//package com.example.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class AppliationSecurityConfiguration extends WebSecurityConfigurerAdapter{
//	
//	
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		//auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("user").password("user123").authorities("USER").and().withUser("admin").password("admin123").authorities("ADMIN");
//		//auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("user").password("user123").authorities("USER");
//		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("user").password("user123")
//        .authorities("ROLE_USER").and().withUser("admin").password("admin123")
//        .authorities("ROLE_ADMIN");
//	
//	}
//	
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		//http.antMatcher("/basic/user**").authorizeRequests().anyRequest().hasRole("USER").and().formLogin().and().antMatcher("/basic/admin**").authorizeRequests().anyRequest().hasRole("ADMIN").and().formLogin();
//		//http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/basic/user/*").hasAnyRole("USER").antMatchers("/basic/admin/*").hasRole("ADMIN").anyRequest().authenticated().and().formLogin();
//		//http.authorizeRequests().antMatchers("/**").hasAnyRole("USER").and().formLogin();
//		http.authorizeRequests().antMatchers("/basic/user/greet").hasAnyRole("USER").antMatchers("/basic/admin/greet").hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin().permitAll();
//	
//	}
//	
//	
//
//}
