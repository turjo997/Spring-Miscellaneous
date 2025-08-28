package com.spring.apache.pdf.repo;

import com.spring.apache.pdf.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice , Long> {
}
