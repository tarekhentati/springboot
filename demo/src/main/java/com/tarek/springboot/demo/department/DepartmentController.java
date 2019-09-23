package com.tarek.springboot.demo.department;

import com.tarek.springboot.demo.data.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Department>> getAllDepartment() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PostMapping(value = "/insert")
    public ResponseEntity insertDepartment(@NotBlank @RequestParam String name, @NotBlank @RequestParam String location) {

        Department newDepartment = new Department(name, location);
        departmentService.insertDepartment(newDepartment);
        return ResponseEntity.ok("");
    }

}
