package com.tmicroservice.employeeservice.controller;

import com.tmicroservice.employeeservice.model.Employee;
import com.tmicroservice.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee department) {
        return employeeRepository.saveEmployee(department);
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Integer id) {
        return employeeRepository.getEmployeeById(id);
    }

    @GetMapping("/department/{id}")
    public List<Employee> findByDepartmentId(@PathVariable Integer id) {
        return employeeRepository.getEmployeesDepartmentId(id);
    }
}
