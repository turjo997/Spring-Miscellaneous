package com.spring.file_operations2.repo;

import com.spring.file_operations2.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice , Long> {
}
