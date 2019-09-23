package com.tarek.springboot.demo.data.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location")
    private String location;

    @Lazy
    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Employee> employeeList;

    @CreationTimestamp
    @Column(name = "creation_date")
    private Date creationDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private Date updatedDate;

    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }
}
