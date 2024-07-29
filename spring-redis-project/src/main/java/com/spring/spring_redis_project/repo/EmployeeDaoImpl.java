package com.spring.spring_redis_project.repo;

import com.spring.spring_redis_project.dao.IEmployeeDao;
import com.spring.spring_redis_project.model.Employee;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

    private final String hashReference = "Employee";

    @Resource(name = "redisTemplate")
    private HashOperations<String , Integer , Employee> hashOperations;

    @Override
    public void saveEmployee(Employee emp) {
        hashOperations.putIfAbsent(hashReference , emp.getEmpId() , emp);
    }

    @Override
    public Employee getOneEmployee(Integer id) {
        return hashOperations.get(hashReference , id);
    }

    @Override
    public void updateEmployee(Employee emp) {
       hashOperations.put(hashReference , emp.getEmpId(),  emp);
    }

    @Override
    public Map<Integer, Employee> getAllEmployees() {
        return hashOperations.entries(hashReference);
    }

    @Override
    public void deleteEmployee(Integer id) {
      hashOperations.delete(hashReference , id);
    }

    @Override
    public void saveAllEmployees(Map<Integer, Employee> map) {
        hashOperations.putAll(hashReference , map);
    }
}
