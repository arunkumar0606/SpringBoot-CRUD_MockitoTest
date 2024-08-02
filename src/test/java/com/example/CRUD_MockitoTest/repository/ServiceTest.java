package com.example.CRUD_MockitoTest.repository;

import com.example.CRUD_MockitoTest.Exception.BannedEmployeeException;
import com.example.CRUD_MockitoTest.model.Employee;
import com.example.CRUD_MockitoTest.service.EmployeeService;


import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ServiceTest {

   // EmployeeRepository employeeRepository=mock(EmployeeRepository.class);
    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeService employeeService;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getEmployeeSample_test() throws BannedEmployeeException {

        /**
         * Stubbing Methods :
         * when,thenReturn,thenThrow,thenAnswer,thenCallRealMethod
         * doReturn,doAnswer,doThrow,doCallRealMethod
         */

        //Arrange
        //When - thenReturn
        when(employeeRepository.existsById(1)).thenReturn(true);
        when(employeeRepository.findById(1)).thenReturn(Optional.of(new Employee(1, "arun", "arun@gmail.com", 60)));
        when(employeeRepository.existsById(2)).thenReturn(false);
        ResponseEntity<Object> e=employeeService.getEmployeeById(1);
        ResponseEntity<Object> fail=employeeService.getEmployeeById(2);
        Optional name= (Optional) e.getBody();
        Employee ew = (Employee) name.get();
        assertEquals("arun",ew.getEmpName());
        assertEquals(HttpStatus.BAD_REQUEST,fail.getStatusCode());

        //AssertThrows
        Exception ex= assertThrows(BannedEmployeeException.class,()->employeeService.checkEmployeeEligibility(13));
        assertEquals(ex.getMessage(),"Employee banned");


//
//        Exception ban= assertThrows(BannedEmployeeException.class,()->employeeService.getEmployeeById(7));
//        assertEquals(ban.getMessage(),"Employee banned");






    }



    
}
