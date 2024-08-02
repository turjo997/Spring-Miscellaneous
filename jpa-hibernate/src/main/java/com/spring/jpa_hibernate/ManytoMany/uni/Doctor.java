package com.spring.jpa_hibernate.ManytoMany.uni;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Doctor {
    @Id
    @GeneratedValue

    private Integer doctorId;
    private String doctorName;
    private String doctorPwd;

    @ManyToMany
    private List<DoctorRole> doctorRoles;
}
