package com.spring.Jbdc_Security_Postgres.service.impl;

import com.spring.Jbdc_Security_Postgres.entity.Role;
import com.spring.Jbdc_Security_Postgres.entity.RoleEnum;

public interface RoleService {
    Role addRole(RoleEnum roleEnum);
    Role getRole(String roleName);
}
