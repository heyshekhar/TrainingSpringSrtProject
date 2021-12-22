package com.eci.training;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	EntityManager em;
	
//	@Value("${spring.datasource.url}")
//	String databaseUrl;
//	
//	@Value("${spring.datasource.url}")
//	String databaseUser;
//	
//	@Value("${spring.datasource.url}")
//	String databasePass;
//	
//	@Value("${spring.datasource.url}")
//	String DriverClassName;
	
	
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.inMemoryAuthentication()
	 * .withUser("eci").password("{noop}ecipass").roles("user") .and()
	 * .withUser("admin").password("{noop}admin").roles("user","admin"); //in spring
	 * many algorithem is there for password you can you that // in the db stored as
	 * {sha256}aa12ffbbcc }
	 */ 
	
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
        auth
          .jdbcAuthentication()
          .dataSource(dataSource())
          .usersByUsernameQuery(
        		   "select username,password, enabled from users where username=?")
          .authoritiesByUsernameQuery(
           "select username, role from user_roles where username=?");
    }

	
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/ecispringboot");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("Dell@123");
		return driverManagerDataSource;
	}
	 

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated()
				.and().httpBasic();
	}

}
