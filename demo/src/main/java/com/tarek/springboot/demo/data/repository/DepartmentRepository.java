package com.tarek.springboot.demo.data.repository;

import com.tarek.springboot.demo.data.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
