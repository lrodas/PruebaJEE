package com.example.employees.service;

import com.example.employees.model.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(String nombre, String correo, String departamento);
    List<Employee> getAllEmployees();
}