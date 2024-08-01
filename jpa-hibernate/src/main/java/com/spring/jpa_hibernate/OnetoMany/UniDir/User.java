package com.spring.jpa_hibernate.OnetoMany.UniDir;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer userId;
    private String userName;
    private String userPwd;

    @OneToMany
    private List<UserRole> userRoles;
}
