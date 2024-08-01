package com.spring.jpa_hibernate.OnetoMany.UniDir;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserRole {
    @Id
    @GeneratedValue
    private Integer roleId;
    private String roleName;
}
