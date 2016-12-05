package com.ibsu.repositories;

import com.ibsu.entities.Department;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {

    List<Department> findAll();
}
