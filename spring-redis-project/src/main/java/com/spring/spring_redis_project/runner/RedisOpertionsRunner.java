package com.spring.spring_redis_project.runner;

import com.spring.spring_redis_project.dao.IEmployeeDao;
import com.spring.spring_redis_project.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RedisOpertionsRunner implements CommandLineRunner {

    @Autowired
    private IEmployeeDao empDao;

    @Override
    public void run(String... args) throws Exception {
        empDao.saveEmployee(new Employee(500, "Emp0", 2150.0));

        empDao.saveAllEmployees(
                Map.of( 501, new Employee(501, "Emp1", 2396.0),
                        502, new Employee(502, "Emp2", 2499.5),
                        503, new Employee(503, "Emp4", 2324.75)
                )
        );

        empDao.updateEmployee(new Employee(503, "Emp3", 2325.25));

        System.out.println("Emp details for 501 : "+empDao.getOneEmployee(501));

        empDao.getAllEmployees().forEach((k,v)-> System.out.println(k+ " : " +v));

        empDao.deleteEmployee(503);
    }
}
