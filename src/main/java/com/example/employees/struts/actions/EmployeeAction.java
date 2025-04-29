package com.example.employees.struts.actions;

import com.example.employees.model.Employee;
import com.example.employees.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

public class EmployeeAction extends ActionSupport {

    private String name;
    private String email;
    private String department;

    private List<Employee> employees;

    private EmployeeService employeeService;

    public String showForm() {
        return SUCCESS;
    }

    public String register() {
        System.out.println("employe: " + name);
        if (name == null || name.trim().isEmpty()) {
            addFieldError("name", "El nombre es obligatorio");
            return INPUT;
        }

        try {
            System.out.println("employe: " + name);
            employeeService.saveEmployee(name, email, department);
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Error saving employee: " + e.getMessage());
            return ERROR;
        }
    }

    public String list() {
        try {
            employees = employeeService.getAllEmployees();
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Error loading employees: " + e.getMessage());
            return ERROR;
        }
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}