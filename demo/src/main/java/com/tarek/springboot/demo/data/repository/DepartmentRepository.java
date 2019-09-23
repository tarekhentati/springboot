package com.tarek.springboot.demo.data.repository;

import com.tarek.springboot.demo.data.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    //Custom JPQL Query
    @Query("select d from Department d where d.name = :name")
    Department findByNameCustomQuery(@Param("name") String name);

    //Custom native Query
    @Query(value = "select * from department as d where d.name = :name",
            nativeQuery = true)
    Department findByNameNativeQuery(@Param("name") String name);
}
