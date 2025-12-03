package com.iwl.report.service;

import com.iwl.report.domain.Ledger;
import com.iwl.report.dto.TrialBalanceRow;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReportHelper {

    public static Map<String, TrialBalanceRow> accumulate(List<Ledger> ledgerList) {
        Map<String, TrialBalanceRow> map = new LinkedHashMap<>();

        for (Ledger l : ledgerList) {
            String name = l.getAccount().getName();

            map.putIfAbsent(name, new TrialBalanceRow(
                    name,
                    BigDecimal.ZERO,
                    BigDecimal.ZERO
            ));

            TrialBalanceRow row = map.get(name);

            row.setDebit(row.getDebit().add(l.getDebit()));
            row.setCredit(row.getCredit().add(l.getCredit()));
        }

        return map;
    }
}
