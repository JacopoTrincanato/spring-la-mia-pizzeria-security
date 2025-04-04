package org.lessons.java.pizza_security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // creo un metodo per la filterChain
    @Bean
    @SuppressWarnings("removal")
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        // regole per i filtri
        httpSecurity.authorizeHttpRequests().requestMatchers("/pizze/create", "/pizze/edit/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/pizze/**").hasAuthority("ADMIN")
                .requestMatchers("/offerte_speciali", "/offerte_speciali/**").hasAuthority("ADMIN")
                .requestMatchers("/ingredienti", "/ingredienti/**").hasAuthority("ADMIN")
                .requestMatchers("/pizze", "/pizze/**").hasAnyAuthority("USER", "ADMIN").requestMatchers("/**")
                .permitAll().and().formLogin().and().logout().and().exceptionHandling();

        return httpSecurity.build();
    }

    // elemento userDetails

    // elemento passwordEncoder
}
