package com.ibsu.filter;

import com.ibsu.Utils.Tools;
import com.ibsu.dto.AddDepartmentDTO;
import com.ibsu.entities.Department;
import com.ibsu.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DepartmentFilter {

    @Autowired
    private DepartmentService departmentService;

    public Department addDepartment(AddDepartmentDTO addDepartmentDTO) throws Exception {
        Tools.checkRequiredProperties(addDepartmentDTO, Arrays.asList("departmentName"));
        return this.departmentService.addDepartment(addDepartmentDTO);
    }

}
