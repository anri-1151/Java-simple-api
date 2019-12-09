package com.ibsu.repositories;

import com.ibsu.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findAll();
}
