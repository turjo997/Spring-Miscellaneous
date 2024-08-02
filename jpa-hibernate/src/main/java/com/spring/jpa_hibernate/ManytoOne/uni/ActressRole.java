package com.spring.jpa_hibernate.ManytoOne.uni;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ActressRole {

    @Id
    @GeneratedValue
    private Integer roleId;
    private String roleName;
}
