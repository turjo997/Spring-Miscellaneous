package com.iwl.report.service;

import com.iwl.report.dto.ReportRequest;
import com.iwl.report.dto.TrialBalanceResponse;

public abstract class BaseReportService<T> {
    /**
     * Generate the report for the given request.
     */
    public abstract T generateReport(ReportRequest request);
}
