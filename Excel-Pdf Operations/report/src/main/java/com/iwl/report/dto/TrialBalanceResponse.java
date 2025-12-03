package com.iwl.report.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrialBalanceResponse {
    private String title;                    // e.g. "Trial Balance - Jan 2025"
    private List<TrialBalanceRow> rows;      // rows for the table
    private BigDecimal totalDebit;           // pre-calculated total debit
    private BigDecimal totalCredit;          // pre-calculated total credit
    private Map<String, Object> summary;     // optional: subtotals, balances, metadata
}
