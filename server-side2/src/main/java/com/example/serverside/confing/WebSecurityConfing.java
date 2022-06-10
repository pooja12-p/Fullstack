package com.example.serverside.confing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.serverside.jwt.JwtAuthorizationFilter;
import com.example.serverside.jwt.JwtTokenProvider;

@Configuration
@EnableWebSecurity
public class WebSecurityConfing extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();															
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//cross-origin-resource-sharing
		String httpMethod;
		String pattern;
		http.cors().and() 
		
			.authorizeRequests() 				//ExpressioninterceptUrlRegistry
			//this are public pages
			.antMatchers("/resources/**","/error","/api/user/**").permitAll()
			// this can be reachable for just have student role
			.antMatchers("/api/student/**").hasRole("STUDENT")
			// this can be reachable for just have teacher role
			.antMatchers("/api/teacher/**").hasRole("TEACHER")
			// this can be reachable for just have manager role
			.antMatchers("/api/manager/**").hasRole("MANAGER")
			//All remaining path should need authentication
			.anyRequest().fullyAuthenticated()
			.and()
			//Logout will log the user out by invalid dated session
			.logout().permitAll()
			.logoutRequestMatcher(new AntPathRequestMatcher( pattern= "/api/user/logout", httpMethod= "POST"))
			.and()
			//login form and path.
			.formLogin().loginPage("/api/user/login").and()
			//Enable basic authentication http header"basic:usernsme:password"
			.httpBasic().and()
			//cross side request forgery
			.csrf().disable();
		//jwt filter
		http.addFilter(new JwtAuthorizationFilter(authenticationManager(), jwtTokenProvider));
		
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{	
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
			}
		};
	}
}
