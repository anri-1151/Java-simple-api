package com.ibsu.controllers;

import com.ibsu.Utils.RequestObject;
import com.ibsu.dto.AddDepartmentDTO;
import com.ibsu.entities.Department;
import com.ibsu.filter.DepartmentFilter;
import com.ibsu.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentFilter departmentFilter;

    @RequestMapping(value = "/getAll", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public List<Department> getAllDepartment() {
        return this.departmentService.getAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public Department addDepartment(@RequestBody RequestObject<AddDepartmentDTO> requestObject) throws Exception {
        return this.departmentFilter.addDepartment(requestObject.getData());
    }

}
