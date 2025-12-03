package com.iwl.report.service;

import com.iwl.report.domain.Ledger;
import com.iwl.report.dto.ReportRequest;
import com.iwl.report.dto.TrialBalanceResponse;
import com.iwl.report.dto.TrialBalanceRow;
import com.iwl.report.repository.LedgerRepository;
import org.springframework.cache.annotation.Cacheable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TrialBalanceService extends BaseReportService<TrialBalanceResponse> {

    private final LedgerRepository ledgerRepository;

    /**
     * Cache key uses Objects.toString so null dates become the string "null" instead of throwing.
     */
    @Override
    @Cacheable(
            value = "trialBalanceCache",
            key = "T(java.util.Objects).toString(#request.startDate) + '-' + T(java.util.Objects).toString(#request.endDate)"
    )
    public TrialBalanceResponse generateReport(ReportRequest request) {

        // validate request (optional)
        if (request == null) {
            throw new IllegalArgumentException("ReportRequest must not be null");
        }

        // 1. Fetch ledger entries
        List<Ledger> ledgerList = ledgerRepository.findAllByTxDateBetween(
                request.getStartDate(),
                request.getEndDate()
        );

        // 2. Convert and accumulate into TrialBalanceRow list
        List<TrialBalanceRow> rows = ReportHelper.accumulate(ledgerList)
                .values()
                .stream()
                .toList();

        // 3. Calculate totals
        BigDecimal totalDebit = rows.stream()
                .map(TrialBalanceRow::getDebit)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalCredit = rows.stream()
                .map(TrialBalanceRow::getCredit)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 4. Build and return response
        return TrialBalanceResponse.builder()
                .title("Trial Balance")
                .rows(rows)
                .totalDebit(totalDebit)
                .totalCredit(totalCredit)
                .summary(Map.of(
                        "rowCount", rows.size(),
                        "startDate", request.getStartDate(),
                        "endDate", request.getEndDate()
                ))
                .build();
    }
}