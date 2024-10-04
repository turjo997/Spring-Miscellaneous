package com.spring.dynamic_report_itext_pdf.repo;

import com.spring.dynamic_report_itext_pdf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee , Integer> {
    @Query("FROM Employee e")
    List<Employee> getAllEmployeeData();

}
