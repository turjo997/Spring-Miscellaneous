package com.spring.excel_poiji_api.repo;

import com.spring.excel_poiji_api.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepo extends JpaRepository<Invoice , Long> {
}
