package com.example.reservation.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                .anyRequest()
                .authenticated());
        http.formLogin(login -> login
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .permitAll()) ;
//        http.formLogin().successForwardUrl("/home");
//        http.formLogin(login -> login.loginPage("/login").permitAll());
        http.logout()
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
        http.csrf().disable();
        return http.build();
    }
}