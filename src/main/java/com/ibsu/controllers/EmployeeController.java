package com.ibsu.controllers;


import com.ibsu.Utils.RequestObject;
import com.ibsu.dto.AddEmployeeDTO;
import com.ibsu.dto.GetEmployeeDTO;
import com.ibsu.entities.Employee;
import com.ibsu.filter.EmployeeFilter;
import com.ibsu.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeFilter employeeFilter;

    @RequestMapping(value = "/getAll", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public List<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployee();
    }

    @RequestMapping(value = "/getOne", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public Employee getEmployee(@RequestBody RequestObject<GetEmployeeDTO> requestObject) {
        return this.employeeService.getSelectedEmployee(requestObject.getData());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public Employee add(@RequestBody RequestObject<AddEmployeeDTO> requestObject) throws Exception {
        return this.employeeFilter.addEmployee(requestObject.getData());
    }

}
