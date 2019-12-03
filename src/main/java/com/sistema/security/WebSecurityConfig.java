package com.sistema.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private ImplementsFuncionarioDetailsService funcionarioDetailsService;

    //csrf significa cross-site request forgery para evitar falsificação de request
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/cadastrarFuncionario").permitAll()
                .anyRequest().authenticated().and().formLogin().loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/gerenciarCli").permitAll()
                .and().logout().permitAll()//apenas a pág index do meu sistema não precisa de autenticação
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));//encerra a sessão pelo /logout
    }
    //BCrypt gera uma senha criptografada
    protected void configure(AuthenticationManagerBuilder autenticacao) throws Exception{
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        autenticacao.userDetailsService(funcionarioDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web){//para não bloquear as pág static
        web.ignoring().antMatchers("/vendor/**", "/css/**" , "/scss/**" , "/.idea/**" , "/node_modules/**");

    }
}
