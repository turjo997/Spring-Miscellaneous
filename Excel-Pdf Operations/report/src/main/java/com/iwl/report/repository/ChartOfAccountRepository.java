package com.iwl.report.repository;

import com.iwl.report.domain.ChartOfAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartOfAccountRepository extends JpaRepository<ChartOfAccount, Long> {
}
