package com.sistema.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // we don't care for CSRF in this example
                .formLogin()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

}
