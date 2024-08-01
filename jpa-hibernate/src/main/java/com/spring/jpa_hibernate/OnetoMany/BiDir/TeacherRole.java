package com.spring.jpa_hibernate.OnetoMany.BiDir;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class TeacherRole {

    @Id
    @GeneratedValue
    private Integer teacherRoleId;
    private String teacherRoleName;

    @ManyToOne
    private Teacher teacher;
}
