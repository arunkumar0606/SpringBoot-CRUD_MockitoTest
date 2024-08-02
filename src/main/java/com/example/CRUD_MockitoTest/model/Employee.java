package com.example.CRUD_MockitoTest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder(builderClassName="Builder")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

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

}
