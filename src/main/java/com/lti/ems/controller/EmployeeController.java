package com.lti.ems.controller;

import com.lti.ems.model.Employee;
import com.lti.ems.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @RequestMapping(value = "/create-employee", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        HttpStatus httpStatus = HttpStatus.OK;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Message", "Employee created bro!");
        return new ResponseEntity<>(employeeService.addEmployee(employee), httpHeaders, httpStatus);
    }

    @RequestMapping(value = {"/employees", "/employees/"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List> outputAllEmployees() {
        HttpStatus httpStatus = HttpStatus.OK;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Message", "Here are all the employees bro!");
        return new ResponseEntity<>(employeeService.getAllEmployees(), httpHeaders, httpStatus);
    }

    @RequestMapping(value = {"/employees/{emp_Id}", "/employees/id/{emp_Id}"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Employee> outputOneEmployeeById(@PathVariable(name = "emp_Id") int empId) {
        Employee employee = employeeService.getEmployeeByID(empId);
        HttpStatus httpStatus = HttpStatus.FOUND;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Message", "Here's your employee bro!");

        return new ResponseEntity<>(employee, httpHeaders, httpStatus);
    }


    @RequestMapping(value = "/delete-employee/{eid}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable(name = "eid") int employeeId) {
        Employee emp = employeeService.deleteEmployee(employeeId);
        HttpStatus status = HttpStatus.CREATED;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Message", "Employee was deleted successfully!");
        ResponseEntity<Employee> response = new ResponseEntity<>(emp, headers, status);
        return response;
    }
}