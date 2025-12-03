package com.iwl.report.domain;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "chart_of_account")
@Data
public class ChartOfAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String code;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 50)
    private String type; // Asset, Liability, Equity, Income, Expense
}
