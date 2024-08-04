package com.spring.Jdbc_Security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {


    @Autowired
    private DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Bean
    UserDetailsManager users() {

        UserDetails user = User.builder()
                .username("emp")
                .password(passwordEncoder.encode("pass1"))
                .roles("EMPLOYEE")
                .build();


        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("pass2"))
                .roles("ADMIN")
                .build();

        UserDetails manager = User.builder()
                .username("manager")
                .password(passwordEncoder.encode("pass3"))
                .roles("MANAGER")
                .build();

        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.createUser(user);
        users.createUser(admin);
        users.createUser(manager);

        return users;
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests()
                .requestMatchers("/home").permitAll()
                .requestMatchers("/welcome").authenticated()
                .requestMatchers("/employee").hasRole("EMPLOYEE")
                .requestMatchers("/manager").hasRole("MANAGER")
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/common").hasAnyRole("EMPLOYEE" , "MANAGER")

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




    //    private void initializeRoles() {
//        roleService.addRole(RoleEnum.ADMIN);
//        roleService.addRole(RoleEnum.EMPLOYEE);
//        roleService.addRole(RoleEnum.MANAGER);
//    }

//    @Bean
//    JdbcUserDetailsManager users(DataSource dataSource) {
//
//        initializeRoles();
//
//        Set<RoleEntity> roles = new HashSet<>();
//
//        Set<String> userRequest = new HashSet<>();
//
//        userRequest.add("ADMIN");
//
//        //userRequest.forEach(value -> roles.add(roleService.getRole(value)));
//
//
//
//        userRequest.forEach(value -> {
//            RoleEntity role = roleService.getRole(value);
//            if (role != null) {
//                roles.add(role);
//            } else {
//                // Log or handle the case where the role is not found
//                System.out.println("Role " + value + " not found");
//            }
//        });
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder.encode("pass"))
//                .roles(String.valueOf(RoleEnum.ADMIN))
//                .build();
//
//        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//
//        users.createUser(admin);
//        return users;
//    }
}
