package com.iwl.report.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReportRequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private Long branchId; // optional
}