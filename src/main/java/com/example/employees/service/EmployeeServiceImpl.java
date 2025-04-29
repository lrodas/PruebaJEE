package com.example.employees.service;

import com.example.employees.dao.EmployeeDao;
import com.example.employees.model.Employee;
import com.example.employees.service.EmployeeService;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Override
    public void saveEmployee(String nombre, String correo, String departamento) {
        employeeDao.save(nombre, correo, departamento);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    // Setter para inyección de dependencias
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
