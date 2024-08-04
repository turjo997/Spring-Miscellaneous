package com.spring.Jbdc_Security_Postgres.service.impl.impl;

import com.spring.Jbdc_Security_Postgres.entity.Role;
import com.spring.Jbdc_Security_Postgres.entity.RoleEnum;
import com.spring.Jbdc_Security_Postgres.repository.RoleRepository;
import com.spring.Jbdc_Security_Postgres.service.impl.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;


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
