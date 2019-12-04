package com.sistema.trajes.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EntityScan(basePackages = "com.sistema")
@ComponentScan(basePackages = "com.sistema")
@EnableJpaRepositories(basePackages = "com.sistema")
@EnableTransactionManagement
@SpringBootApplication
public class TrajesApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TrajesApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(TrajesApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }

}
