package com.spring.In_Memory_Security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    protected InMemoryUserDetailsManager configAuthentication(){
        List<UserDetails> users = new ArrayList<>();
        List<GrantedAuthority> adminAuthority = new ArrayList<>();
        adminAuthority.add(new SimpleGrantedAuthority("ADMIN"));
        UserDetails admin = new User("devs" , "{noop}devs", adminAuthority);
        users.add(admin);

        List<GrantedAuthority> employeeAuthority = new ArrayList<>();
        employeeAuthority.add(new SimpleGrantedAuthority("EMPLOYEE"));
        UserDetails employee= new User("ns", "{noop}ns", employeeAuthority);
        users.add(employee);

        List<GrantedAuthority> managerAuthority = new ArrayList<>();
        managerAuthority.add(new SimpleGrantedAuthority("MANAGER"));
        UserDetails manager= new User("vs", "{noop}vs", managerAuthority);
        users.add(manager);

        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

         http.authorizeHttpRequests()
                 .requestMatchers("/home").permitAll()
                 .requestMatchers("/welcome").authenticated()
                 .requestMatchers("/employee").hasAuthority("EMPLOYEE")
                 .requestMatchers("/manager").hasAuthority("MANAGER")
                 .requestMatchers("/admin").hasAuthority("ADMIN")
                 .requestMatchers("/common").hasAnyAuthority("EMPLOYEE" , "MANAGER")

                 .anyRequest().authenticated()

                 //Login Form Details
                 .and()
                 .formLogin()
                 .defaultSuccessUrl("/welcome" , true)

                 //Logout Form Details
                 .and()
                 .logout()
                 .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))

                 //Exception Details
                 .and()
                 .exceptionHandling()
                 .accessDeniedPage("/accessDenied");

         return http.build();
    }

}
