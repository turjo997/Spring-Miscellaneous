package com.iwl.report.repository;

import com.iwl.report.domain.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LedgerRepository extends JpaRepository<Ledger, Long> {

    List<Ledger> findAllByTxDateBetween(LocalDate start, LocalDate end);
}