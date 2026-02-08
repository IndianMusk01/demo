package com.jwt.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

    @Bean
    public UserDetailsService userDetailsService(){
       UserDetails user =  User.builder().username("ayush").password(passwordEncoder().encode("12345")).roles("admin").build();
       UserDetails user1 =  User.builder().username("prince").password(passwordEncoder().encode("12345")).roles("admin").build();
       UserDetails user2 =  User.builder().username("ujjwal").password(passwordEncoder().encode("12345")).roles("admin").build();

        return new InMemoryUserDetailsManager(user, user1, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
