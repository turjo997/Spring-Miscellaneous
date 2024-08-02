package com.spring.jpa_hibernate.OnetoOne.uni;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class FarmerRole {
    @Id
    @GeneratedValue
    private Integer roleId;
    private String roleName;
}
