package com.lti.ems.service;

import com.lti.ems.model.Employee;
import com.lti.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService implements EmployeeServiceImpl {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee getEmployeeByID(int id) {


        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.get();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public Employee deleteEmployee(int employeeId) {
        Employee emp = this.getEmployeeByID(employeeId);
        employeeRepository.deleteById(employeeId);
        return emp;
    }
}
