package com.ibsu.filter;

import com.ibsu.Utils.Tools;
import com.ibsu.dto.AddEmployeeDTO;
import com.ibsu.entities.Employee;
import com.ibsu.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class EmployeeFilter {

    @Autowired
    private EmployeeService employeeService;

    public Employee addEmployee(AddEmployeeDTO addEmployeeDTO) throws Exception {
        Tools.checkRequiredProperties(addEmployeeDTO, Arrays.asList("firstName", "lastName", "salary", "departmentId"));
        return this.employeeService.addEmployee(addEmployeeDTO);
    }

}


