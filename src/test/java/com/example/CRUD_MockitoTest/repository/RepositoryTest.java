package com.example.CRUD_MockitoTest.repository;



import com.example.CRUD_MockitoTest.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * Save Test
     */

    @Test
    @DisplayName("Save Name Test")
    public void employeeSaveTest(){

        Employee employee=Employee.builder()
                .empNo(11)
                .empName("Arun")
                .empEmail("Arun@gmail.com")
                .empAge(24)
                .build();

        Employee savedEmployee=employeeRepository.save(employee);

        assertEquals(savedEmployee.getEmpName(),"Arun");

    }

    @Test
    @DisplayName("Save ALL test")
    public void employeeSaveAllTest(){

        Employee employee1=Employee.builder()
                .empNo(11)
                .empName("Arun")
                .empEmail("Arun@gmail.com")
                .empAge(26)
                .build();

        Employee employee2=Employee.builder()
                .empNo(12)
                .empName("Ammu")
                .empEmail("Ammu@gmail.com")
                .empAge(27)
                .build();

        Employee savedEmployee1=employeeRepository.save(employee1);
        Employee savedEmployee2=employeeRepository.save(employee2);

        List<Employee> employeeList =employeeRepository.findAll();
        assertEquals(employeeList.size(),2);

    }

    /**
     * Update Test
     */

    @Test
    @DisplayName("Update Employee Test")
    public void updateEmployeeTest(){

        Employee employee1=Employee.builder()
                .empNo(11)
                .empName("Arun")
                .empEmail("Arun@gmail.com")
                .empAge(26)
                .build();
        employeeRepository.save(employee1);

        Employee oldEmployee=employeeRepository.findById(11).get();
        oldEmployee.setEmpName("Arun Kumar");

        Employee updatedEmployee=employeeRepository.save(oldEmployee);

        assertEquals(updatedEmployee.getEmpName(),"Arun Kumar");

    }

    /**
     * Delete Test
     */
    @Test
    @DisplayName("Delete Test")
    public void employeeDeleteTest(){

        Employee employee=Employee.builder()
                .empNo(11)
                .empName("Arun")
                .empEmail("Arun@gmail.com")
                .empAge(24)
                .build();

        Employee savedEmployee=employeeRepository.save(employee);

        employeeRepository.deleteById(11);

        Optional<Employee> deletedEmployee=employeeRepository.findById(11);

        Assertions.assertThat(deletedEmployee).isEmpty();

    }

}
