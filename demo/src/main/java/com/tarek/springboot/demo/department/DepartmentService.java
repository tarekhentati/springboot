package com.tarek.springboot.demo.department;

import com.tarek.springboot.demo.data.entity.Department;
import com.tarek.springboot.demo.data.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    Department insertDepartment(Department department) {
        return departmentRepository.save(department);

    }

}
