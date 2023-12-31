package com.codewithabhi.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.codewithabhi.blog.security.CustomUserDetailService;
import com.codewithabhi.blog.security.JwtAuthenticationEntryPoint;
import com.codewithabhi.blog.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	public static final String[] PUBLIC_URLS= {
			"/v3/api-docs",
			"/v2/api-docs",
			"swagger-resources/**",
			"swagger-ui/**",
			"webjars/**"
	};
	
	@Autowired
	private CustomUserDetailService customerUserDetailService;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		      .csrf()
		      .disable()
		      .authorizeHttpRequests()
//		      .antMatchers("/api/v1/auth/login").permitAll()
		      .antMatchers("/api/v1/auth/**").permitAll()
		      .antMatchers(PUBLIC_URLS).permitAll()
		      .antMatchers(HttpMethod.GET).permitAll()
		      .anyRequest()
		      .authenticated()
		      .and()
		      .exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
		      .and()
		      .sessionManagement()
		      .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(this.jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	 {
		 auth.userDetailsService(this.customerUserDetailService).passwordEncoder(passwordEncoder());
	 }
	
	@Bean
    public PasswordEncoder passwordEncoder()
    {
    	return new BCryptPasswordEncoder();
    }
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	  

}
