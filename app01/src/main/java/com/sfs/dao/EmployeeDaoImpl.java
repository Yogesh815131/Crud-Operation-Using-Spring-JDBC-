package com.sfs.dao;

import com.sfs.beans.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public String addEmployee(Employee employee) {
        String status = "";
        int rowCount = jdbcTemplate.update("insert into emp1 values("+employee.getEno()+",'"+employee.getEname()+"',"+employee.getEsal()+",'"+employee.getEaddr()+"')");
        if(rowCount == 1){
            status = "Employee added successfully";
        }else {
            status = "Employee Insertion Failed";
        }
        return status;
    }

    @Override
    public Employee searchEmployee(int employeeId) {
        List<Employee> empList = jdbcTemplate.query("select * from emp1 where eno ="+employeeId, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee employee = new Employee();
                employee.setEno(rs.getInt("eno"));
                employee.setEname(rs.getString("ename"));
                employee.setEsal(rs.getInt("esal"));
                employee.setEaddr(rs.getString("addr"));
                return employee;
            }
        });
        return empList.isEmpty()?null:empList.get(0);
    }

    @Override
    public List<Employee> searchEmployees() {
        List<Employee> employeeList = jdbcTemplate.query("select * from emp1", new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee employee = new Employee();
                employee.setEno(rs.getInt("eno"));
                employee.setEname(rs.getString("ename"));
                employee.setEsal(rs.getInt("esal"));
                employee.setEaddr(rs.getString("addr"));
                return employee;
            }
        });

        return employeeList;
    }

    @Override
    public String updateEmployee(Employee emp) {
        String status = "";
        int rowCount = jdbcTemplate.update("update emp1 set ename = '"+emp.getEname()+"', esal = "+emp.getEsal()+", addr = '"+emp.getEaddr()+"' where eno = "+emp.getEno());
        if(rowCount == 1){
            status = "Employee updated successfully";
        }else {
            status = "Employee Update Failed";
        }
        return status;
    }

    @Override
    public String deleteEmployee(int employeeId) {
        String status = "";
        int rowCount = jdbcTemplate.update("delete from emp1 where eno ="+employeeId);
        if(rowCount == 1){
            status = "Employee deleted successfully";
        }else {
            status = "Employee Deletion Failed";
        }
        return status;
    }


}
