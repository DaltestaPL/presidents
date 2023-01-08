package com.presidents.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/presidents/*").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/presidents/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/save").authenticated()
                .anyRequest().permitAll()
                .and().formLogin()
                .and().httpBasic()
                .and().logout()
                .and().headers().frameOptions().disable()
                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}admin").roles("ADMIN");
    }
}
