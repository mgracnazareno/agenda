package com.projet.agenda.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    //add support for JDBC
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource){
//
//        //tells spring security to use JDBC authentication with our data source
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//        //define query to retrieve a user by username
//        jdbcUserDetailsManager.setUsersByUsernameQuery(
//                "select username, password, enabled from users where username = ?");
//
//// Define query to retrieve authorities/roles by username
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
//                "select u.username, a.nom " +
//                        "from users u " +
//                        "join users_authorities ua on u.id = ua.users_id " +
//                        "join authorities a on ua.authorities_id = a.id " +
//                        "where u.username = ?");
//        return jdbcUserDetailsManager;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                    configurer
                            .requestMatchers("/").hasRole("USER")
                            .requestMatchers("/leaders/**").hasRole("ENTREPRENEUR")
                            .requestMatchers("/systems/**").hasRole("ADMIN")
                            .anyRequest().authenticated()
                )
                .formLogin(form ->
                       form

                        .loginPage("/showLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
                )
                .logout(logout -> logout.permitAll()
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied"));
        return http.build();
    }

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
