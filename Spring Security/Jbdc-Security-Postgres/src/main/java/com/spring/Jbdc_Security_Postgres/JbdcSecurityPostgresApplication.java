package com.spring.Jbdc_Security_Postgres;

import com.spring.Jbdc_Security_Postgres.entity.RoleEnum;
import com.spring.Jbdc_Security_Postgres.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JbdcSecurityPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(JbdcSecurityPostgresApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(RoleService roleService){
        return args -> {
			roleService.addRole(RoleEnum.ADMIN);
			roleService.addRole(RoleEnum.EMPLOYEE);
			roleService.addRole(RoleEnum.MANAGER);
		};
	}
}
