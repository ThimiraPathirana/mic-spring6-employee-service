package com.tmicroservice.employeeservice.repository;

import com.tmicroservice.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    List<Employee> employees = new ArrayList<>();

    public Employee saveEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee getEmployeeById(Integer employeeId) {
        Employee filterVal = employees.stream()
                .filter(employee -> employee.getId().equals(employeeId))
                .findFirst()
                .orElseThrow();
        return filterVal;
    }

    public List<Employee> findAll() {
        return employees;
    }

    public List<Employee> getEmployeesDepartmentId(Integer depId) {
        List<Employee> filterVal = employees.stream()
                .filter(employee -> employee.getDepartmentId().equals(depId))
                .toList();
        return filterVal;
    }
}
