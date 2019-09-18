package com.tarek.springboot.demo.employee;

import com.tarek.springboot.demo.data.entity.Employee;
import com.tarek.springboot.demo.data.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


}
