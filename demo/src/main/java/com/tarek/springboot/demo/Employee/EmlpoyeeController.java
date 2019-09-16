package com.tarek.springboot.demo.Employee;

import com.tarek.springboot.demo.data.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmlpoyeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmlpoyeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Get aLL Employees in the DB
     *
     * @return ResponseEntity<List < Employee>>
     */
    @GetMapping(value = "")
    public ResponseEntity<List<Employee>> getAllEmplyees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return ResponseEntity.ok(allEmployees);
    }

}
