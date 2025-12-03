package com.iwl.report.controller;

import com.iwl.report.dto.ReportRequest;
import com.iwl.report.dto.TrialBalanceRequest;
import com.iwl.report.dto.TrialBalanceResponse;
import com.iwl.report.service.TrialBalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reports")
public class TrialBalanceController {

    private final TrialBalanceService trialBalanceService;

    @GetMapping("/trial-balance")
    public String showForm(Model model) {
        model.addAttribute("report", new TrialBalanceRequest());
        return "reports/trial-balance";
    }

    @PostMapping("/trial-balance")
    public String generateReport(
            @ModelAttribute("report") ReportRequest request,
            Model model
    ) {
        TrialBalanceResponse response = trialBalanceService.generateReport(request);
        model.addAttribute("response", response);
        return "reports/trial-balance";
    }

}