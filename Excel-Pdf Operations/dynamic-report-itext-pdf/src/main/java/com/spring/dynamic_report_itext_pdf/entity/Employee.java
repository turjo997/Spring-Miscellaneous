package com.spring.dynamic_report_itext_pdf.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_id_seq",
            sequenceName = "employee_id_seq",
            allocationSize = 1, initialValue = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_seq")
    private Integer empId;
    private String empName;
    private Double empSal;
    private String empDept;
}
