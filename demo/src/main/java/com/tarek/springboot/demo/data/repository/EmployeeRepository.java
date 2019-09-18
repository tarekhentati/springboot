package com.tarek.springboot.demo.data.repository;

import com.tarek.springboot.demo.data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    Employee findFirstByFirstName(String firstName);

}
