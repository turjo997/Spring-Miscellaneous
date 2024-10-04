package com.spring.dynamic_report_itext_pdf;

import com.spring.dynamic_report_itext_pdf.entity.Employee;
import com.spring.dynamic_report_itext_pdf.repo.EmployeeRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/employee")
public class DynamicReportItextPdfApplication {

	private final EmployeeRepo employeeRepo;

	DynamicReportItextPdfApplication(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

	@PostMapping
	public Employee saveBook(@RequestBody Employee employee){
		return employeeRepo.save(employee);
	}

	public static void main(String[] args) {
		SpringApplication.run(DynamicReportItextPdfApplication.class, args);
	}

}
