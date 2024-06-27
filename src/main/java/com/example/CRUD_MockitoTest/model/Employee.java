package com.example.CRUD_MockitoTest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Employee {

    public Employee(){

    }

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int empNo;

    @NotNull(message = "Please Enter the name")
    private String empName;


    @Email(message = "Please Enter Valid Email")
    private String empEmail;

    @Min(value = 25,message = "Age should be above 25")
    @Max(value = 60,message = "Age should be below 60")
    private int empAge;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }
}
