package com.spring.jpa_hibernate.OnetoMany.BiDir;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Teacher {

    @Id
    @GeneratedValue

    private Integer teacherId;
    private String teacherName;
    private String teacherPwd;

    @OneToMany(mappedBy = "teacher")
    private List<TeacherRole> teacherRoles;
}
