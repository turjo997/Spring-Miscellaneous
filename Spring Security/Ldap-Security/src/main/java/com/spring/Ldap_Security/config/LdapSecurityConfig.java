package com.spring.Ldap_Security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class LdapSecurityConfig {

    protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin();

        //httpSecurity.authenticationProvider();

        return httpSecurity.build();
    }



}
