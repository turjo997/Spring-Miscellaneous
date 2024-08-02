package com.spring.jpa_hibernate.repo;

import com.spring.jpa_hibernate.OnetoMany.BiDir.TeacherRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRoleRepo extends JpaRepository<TeacherRole ,Integer> {
}
