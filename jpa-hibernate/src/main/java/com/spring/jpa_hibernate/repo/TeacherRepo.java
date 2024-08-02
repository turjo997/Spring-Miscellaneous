package com.spring.jpa_hibernate.repo;

import com.spring.jpa_hibernate.OnetoMany.BiDir.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher ,Integer> {
}
