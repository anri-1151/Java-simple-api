package com.ibsu.repositories;

import com.ibsu.entities.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    Employee findOneByEmployeeId(Long employeeId);

    List<Employee> findAll();

}
