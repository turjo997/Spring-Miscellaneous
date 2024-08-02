package com.spring.jpa_hibernate.ManytoMany.bi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Engineer {

    @Id
    @GeneratedValue
    private Integer engId;
    private String engName;
    private String engPwd;

    @ManyToMany
    private List<EngineerRole> engineerRoles;
}
