package com.example.pizzaapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {

        String pepper = "pepper"; // secret key used by password encoding
        int iterations = 200000;  // number of hash iteration
        int hashWidth = 256;
        return new Pbkdf2PasswordEncoder(
                pepper,
                iterations,
                hashWidth,
                Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/design", "/orders")
                .hasRole("ROLE_USER")
                .requestMatchers("/", "/**")
                .permitAll()
           .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/design")
           .and()
                .logout()
                .logoutSuccessUrl("/");

        return http.build();
    }
}
