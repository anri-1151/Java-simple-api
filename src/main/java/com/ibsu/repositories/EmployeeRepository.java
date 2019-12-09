package com.ibsu.repositories;

import com.ibsu.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findOneByEmployeeId(Long employeeId);

    List<Employee> findAll();

}
