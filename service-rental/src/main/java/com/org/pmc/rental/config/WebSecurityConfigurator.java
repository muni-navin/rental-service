package com.org.pmc.rental.config;

import com.pmc.rental.contract.model.DocumentationProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurator {

    @Value("${pmc.service.security.unrestricted-paths}")
    private String[] unrestrictedPaths;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http, DocumentationProperties documentationProperties) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers(unrestrictedPaths).permitAll()
                        .anyRequest()
                        .permitAll())
                .httpBasic();
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().anyRequest();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/users").allowedOrigins("http://localhost:4200");
            }
        };
    }
}
