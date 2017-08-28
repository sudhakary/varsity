package com.osi.charts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
    public UserDetailsService mongoUserDetails() {
        return new CustomerUserDetailsService();
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
		authorizeRequests()
		.antMatchers(HttpMethod.POST, "/").permitAll()
        .antMatchers("/").hasAnyRole("USER", "ADMIN")
        .and().csrf().disable()
            .formLogin().loginPage("/login.html").loginProcessingUrl("/j_spring_security_check")
            .defaultSuccessUrl("/")
            .successHandler(new CustomAuthenticationSuccessHandler())
            .failureUrl("/login.html?failed")
            .usernameParameter("username").passwordParameter("password")                
        .and()
            .logout().logoutUrl("/j_spring_security_logout").deleteCookies("JSESSIONID").invalidateHttpSession(true).logoutSuccessUrl("/login.html")
            .and()
    		.exceptionHandling().accessDeniedPage("/403.html")
            .and().httpBasic();
       
   }
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //auth
            //.inMemoryAuthentication()
                //.withUser("user").password("password").roles("USER");
        UserDetailsService userDetailsService = mongoUserDetails();
        auth.userDetailsService(userDetailsService);
    }
}
