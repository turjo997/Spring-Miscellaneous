package com.spring.Jbdc_Security_Postgres.service.impl;

import com.spring.Jbdc_Security_Postgres.entity.Role;
import com.spring.Jbdc_Security_Postgres.entity.RoleEnum;
import com.spring.Jbdc_Security_Postgres.repository.RoleRepository;
import com.spring.Jbdc_Security_Postgres.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public Role addRole(RoleEnum roleName) {
        if (roleRepository.findByRoleName(roleName.name()).isEmpty()) {
            Role role = new Role();
            role.setRoleName(roleName.name());
            return roleRepository.save(role);
        }
        return null;
    }

    @Override
    public Role getRole(String roleName) {
        Optional<Role> roleEntity = roleRepository.findByRoleName(roleName);

        if(roleEntity.isPresent()){
            return roleEntity.get();
        }
        return null;
    }
}
