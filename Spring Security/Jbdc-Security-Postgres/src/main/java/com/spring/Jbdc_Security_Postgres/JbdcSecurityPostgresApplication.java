package com.spring.Jbdc_Security_Postgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JbdcSecurityPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(JbdcSecurityPostgresApplication.class, args);
	}

	//	@Bean
//	CommandLineRunner runner(RoleService roleService){
//        return args -> {
//			roleService.addRole(RoleEnum.ADMIN);
//			roleService.addRole(RoleEnum.EMPLOYEE);
//			roleService.addRole(RoleEnum.MANAGER);
//		};
//	}
}
