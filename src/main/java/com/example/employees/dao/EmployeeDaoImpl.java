package com.example.employees.dao;

import com.example.employees.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    private static class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getLong("ID"));
            employee.setName(rs.getString("NOMBRE"));
            employee.setMail(rs.getString("CORREO"));
            employee.setDepartment(rs.getString("DEPARTAMENTO"));
            return employee;
        }
    }

    @Override
    public void save(String nombre, String correo, String departamento) {
        System.out.println("Guardando empleado: " + nombre);
        String sql = "INSERT INTO EMPLEADOS (NOMBRE, CORREO, DEPARTAMENTO) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, nombre, correo, departamento);
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM EMPLEADOS";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}