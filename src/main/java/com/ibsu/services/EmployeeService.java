package com.ibsu.services;

import com.ibsu.dto.AddEmployeeDTO;
import com.ibsu.dto.GetEmployeeDTO;
import com.ibsu.entities.Department;
import com.ibsu.entities.Employee;
import com.ibsu.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentService departmentService;

    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }

    public Employee getSelectedEmployee(GetEmployeeDTO getEmployeeDTO) {
        return this.employeeRepository.findById(getEmployeeDTO.getEmployeeId()).orElse(null);
    }

    @Transactional
    public Employee addEmployee(AddEmployeeDTO addEmployeeDTO) {
        Long departmentId = addEmployeeDTO.getDepartmentId();
        Department department = null;
        if (departmentId != null) {
            department = this.departmentService.getOne(departmentId);
        }

        Employee employee = new Employee();
        employee.setFirstName(addEmployeeDTO.getFirstName());
        employee.setLastName(addEmployeeDTO.getLastName());
        employee.setEmail(addEmployeeDTO.getEmail());
        employee.setPhoneNumber(addEmployeeDTO.getPhoneNumber());
        employee.setHireDate(addEmployeeDTO.getHireDate());
        employee.setSalary(addEmployeeDTO.getSalary());
        employee.setSalary(addEmployeeDTO.getSalary());
        employee.setCommissionPct(addEmployeeDTO.getCommissionPct());
        employee.setDepartment(department);

        return this.employeeRepository.save(employee);

    }

}
