package com.spring.Jbdc_Security_Postgres.service.impl;

import com.spring.Jbdc_Security_Postgres.entity.Role;
import com.spring.Jbdc_Security_Postgres.entity.User;
import com.spring.Jbdc_Security_Postgres.repository.RoleRepository;
import com.spring.Jbdc_Security_Postgres.repository.UserRepository;
import com.spring.Jbdc_Security_Postgres.service.IUserService;
import com.spring.Jbdc_Security_Postgres.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleRepository roleRepository;



    @Override
    public Long saveUser(User user) {

        //Set<Role> roles = new HashSet<>();

        //user.getRoles().forEach(value->roles.add(roleService.getRole(value.getRoleName())));


        Set<Role> roles = new HashSet<>();

        //following both are same


//        for (Integer roleId : user.getRoleIds()) {
//            Role role = roleRepository.findById(roleId)
//                    .orElseThrow(() -> new IllegalArgumentException("Invalid role ID: " + roleId));
//            roles.add(role);
//        }


        user.getRoleIds().forEach(value->roles.add(roleRepository.findById(value)
                .orElseThrow(()->new IllegalArgumentException("Invalid role ID: " +value))));

        user.setRoles(roles);
        user.setUsername(user.getUsername());
        String passwd = user.getPassword();
        String encodedPass = passwordEncoder.encode(passwd);
        user.setPassword(encodedPass);
        user.setEmail(user.getEmail());
        user.setRoles(roles);
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
    }



//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       // If I want to use this, then in User entity I must implement userdetails to set username
//        // pass , authority to the spring user
//
//        return userRepository.findByUsername(username)
//                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
//    }
}
