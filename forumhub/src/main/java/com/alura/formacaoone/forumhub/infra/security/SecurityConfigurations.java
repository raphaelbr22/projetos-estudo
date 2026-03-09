package com.alura.formacaoone.forumhub.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable()) // Desabilita CSRF para testar o POST com Insomnia
                .authorizeHttpRequests(req -> {
                    req.requestMatchers("/topicos").permitAll(); // Libera nosso endpoint
                    req.anyRequest().authenticated();
                })
                .build();
    }
}