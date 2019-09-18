package com.tarek.springboot.demo.employee.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class AddEmployeeWrapper {

    @NotBlank(message = "first name is mandatory")
    private String firstName;

    @NotBlank(message = "last name is mandatory")
    private String lastName;

    @Min(18)
    private int age;

    private double salary;

}
