package com.jwt.example.demo.config;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class AppConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public static class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            PrintWriter writer = response.getWriter();
            writer.println("ACCESS DENIED !!" + authException.getMessage());
        }
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user =  User.builder().username("ayush").password(passwordEncoder().encode("12345")).roles("admin").build();
        UserDetails user1 =  User.builder().username("prince").password(passwordEncoder().encode("12345")).roles("admin").build();
        UserDetails user2 =  User.builder().username("ujjwal").password(passwordEncoder().encode("12345")).roles("admin").build();

        return new InMemoryUserDetailsManager(user, user1, user2);
    }
}
