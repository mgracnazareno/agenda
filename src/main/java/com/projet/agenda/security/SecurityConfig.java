package com.projet.agenda.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("USER")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test456")
                .roles("USER", "ENTREPRENEUR")
                .build();

        UserDetails susan= User.builder()
                .username("susan")
                .password("{noop}test789")
                .roles("USER", "ENTREPRENEUR", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
}
