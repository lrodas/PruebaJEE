package com.example.employees.model;

public class Employee {
    private Long id;
    private String name;
    private String mail;
    private String department;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}