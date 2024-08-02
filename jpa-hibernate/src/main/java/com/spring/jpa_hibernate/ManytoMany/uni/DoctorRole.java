package com.spring.jpa_hibernate.ManytoMany.uni;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class DoctorRole {

    @Id
    @GeneratedValue
    private Integer roleId;
    private String roleName;
}
