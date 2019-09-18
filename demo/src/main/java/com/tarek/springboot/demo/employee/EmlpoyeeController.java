package com.tarek.springboot.demo.employee;

import com.tarek.springboot.demo.data.entity.Employee;
import com.tarek.springboot.demo.employee.wrapper.AddEmployeeWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping(value = "/insert")
    public ResponseEntity addEmployee(@Valid @RequestBody AddEmployeeWrapper addEmployeeWrapper) {

        Employee newEmployee = new Employee(addEmployeeWrapper.getFirstName(), addEmployeeWrapper.getLastName(),
                addEmployeeWrapper.getAge(), addEmployeeWrapper.getSalary());

        employeeService.addEmployee(newEmployee);
        return ResponseEntity.ok("");
    }

}
