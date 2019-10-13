package com.sistema.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //csrf significa cross-site request forgery para evitar falsificação de request
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET, "/index").permitAll()
                .anyRequest().authenticated().and().formLogin().permitAll().and().logout()//apenas a pág index do meu sistema não precisa de autenticação
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));//encerra a sessão pelo /logout
    }

    protected void configure(AuthenticationManagerBuilder autenticacao) throws Exception{//autenticacao em memória
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        autenticacao.inMemoryAuthentication().withUser("user").password(encoder.encode("1234")).roles("ADMIN");//passa o user,senha e o papel do user
    }

    @Override
    public void configure(WebSecurity web){//para não bloquear as pág static
        web.ignoring().antMatchers("/vendor/**", "/css/**" , "/scss/**" , "/.idea/**" , "/node_modules/**");

    }
}
