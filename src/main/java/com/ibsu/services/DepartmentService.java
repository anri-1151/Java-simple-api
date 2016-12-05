package com.ibsu.services;

import com.ibsu.dto.AddDepartmentDTO;
import com.ibsu.dto.GetDepartmentDTO;
import com.ibsu.entities.Department;
import com.ibsu.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAll() {
        return this.departmentRepository.findAll();
    }

    public Department addDepartment(AddDepartmentDTO addDepartmentDTO) {
        Department department = new Department();
        department.setDepartmentName(addDepartmentDTO.getDepartmentName());
        return this.departmentRepository.save(department);
    }

    public Department getOne(GetDepartmentDTO getDepartmentDTO) {
        return this.departmentRepository.findOne(getDepartmentDTO.getDepartmentId());
    }

    public Department getOne(Long departmentId) {
        GetDepartmentDTO getDepartmentDTO = new GetDepartmentDTO();
        getDepartmentDTO.setDepartmentId(departmentId);
        return getOne(getDepartmentDTO);
    }

}
