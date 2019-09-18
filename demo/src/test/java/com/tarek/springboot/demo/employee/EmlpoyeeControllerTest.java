package com.tarek.springboot.demo.employee;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tarek.springboot.demo.data.entity.Employee;
import com.tarek.springboot.demo.data.repository.EmployeeRepository;
import com.tarek.springboot.demo.employee.wrapper.AddEmployeeWrapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmlpoyeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmployeeRepository employeeRepository;


    @BeforeEach
    void setUp() {
    }

    @Test
    void addEmployee() throws Exception {

        AddEmployeeWrapper employee = new AddEmployeeWrapper("Thierry", "ZGHAL", 32, 2000);

        Employee em = new Employee("ff","ff",32,200);

        mockMvc.perform(post("/employees/insert")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk());

        Employee employeeEntity = employeeRepository.findFirstByFirstName("Thierry");
        assertEquals(employee.getFirstName(), employeeEntity.getFirstName());

    }

}