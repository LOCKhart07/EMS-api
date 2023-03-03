package com.lti.ems.service;

import com.lti.ems.model.Employee;

import java.util.List;

public interface EmployeeServiceImpl {
    Employee getEmployeeByID(int id);

    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();


    Employee deleteEmployee(int employeeId);
}
