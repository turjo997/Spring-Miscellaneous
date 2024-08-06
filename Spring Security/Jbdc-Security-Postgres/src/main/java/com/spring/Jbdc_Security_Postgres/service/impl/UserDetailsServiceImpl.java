package com.spring.Jbdc_Security_Postgres.service.impl;

import com.spring.Jbdc_Security_Postgres.entity.User;
import com.spring.Jbdc_Security_Postgres.repository.UserRepository;
import com.spring.Jbdc_Security_Postgres.service.IUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements IUserService, UserDetailsService {

    private final UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder;

    public UserDetailsServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Long saveUser(User user) {
        String passwd = user.getPassword();
        String encodedPass = passwordEncoder.encode(passwd);
        user.setPassword(encodedPass);
        user = userRepository.save(user);

        return user.getUserId();
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> opt = userRepository.findByUsername(username);

        org.springframework.security.core.userdetails.User springUser=null;

        if(opt.isEmpty()) {
            throw new UsernameNotFoundException("User with username: " +username +" not found");
        }else {
            User user =opt.get();
            Set<String> roles = new HashSet<>();
            user.getRoles().forEach(role -> roles.add(role.getRoleName()));

            Set<GrantedAuthority> ga = new HashSet<>();
            for(String role:roles) {
                ga.add(new SimpleGrantedAuthority(role));
            }

            springUser = new org.springframework.security.core.userdetails.User(
                    username,
                    user.getPassword(),
                    ga );
        }
        return springUser;
//
//        return userRepository.findByUsername(username)
//                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
