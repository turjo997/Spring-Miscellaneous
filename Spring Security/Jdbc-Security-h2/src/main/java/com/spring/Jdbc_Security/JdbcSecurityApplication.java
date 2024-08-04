package com.spring.Jdbc_Security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcSecurityApplication.class, args);
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
