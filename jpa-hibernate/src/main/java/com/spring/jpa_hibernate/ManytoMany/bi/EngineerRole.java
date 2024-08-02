package com.spring.jpa_hibernate.ManytoMany.bi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class EngineerRole {

    @Id
    @GeneratedValue
    private Integer roleId;
    private String roleName;

    @ManyToMany(mappedBy = "engineerRoles")
    private List<Engineer> engineerList;
}
