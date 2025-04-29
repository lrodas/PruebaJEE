package com.example.employees.dao;

import com.example.employees.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void save(String nombre, String correo, String departamento);
    List<Employee> findAll();
}
