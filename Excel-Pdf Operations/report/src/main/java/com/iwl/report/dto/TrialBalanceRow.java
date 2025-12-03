package com.iwl.report.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class TrialBalanceRow {
    private String accountName;
    private BigDecimal debit;
    private BigDecimal credit;
}