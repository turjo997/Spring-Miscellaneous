package com.spring.file_operations.config;

import com.spring.file_operations.infrastructure.InvoiceJpaRepository;
import com.spring.file_operations.repository.InvoiceRepository;
import com.spring.file_operations.service.ExcelDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfig {

    private final InvoiceJpaRepository invoiceRepository;

    public CoreConfig(InvoiceJpaRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }


    @Bean
    ExcelDataService getDataService(){
        return new ExcelDataService(invoiceRepository);
    }
}
