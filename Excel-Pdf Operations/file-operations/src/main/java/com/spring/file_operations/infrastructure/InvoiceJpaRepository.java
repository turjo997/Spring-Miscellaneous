package com.spring.file_operations.infrastructure;

import com.spring.file_operations.entity.Invoice;
import com.spring.file_operations.repository.InvoiceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceJpaRepository extends InvoiceRepository, JpaRepository<Invoice, Long> {
}
