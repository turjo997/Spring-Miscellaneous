package com.iwl.report.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TrialBalanceRequest {
    private LocalDate startDate;
    private LocalDate endDate;
}
