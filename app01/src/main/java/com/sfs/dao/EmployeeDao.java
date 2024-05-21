package com.sfs.dao;

import com.sfs.beans.Employee;

import java.util.List;

public interface EmployeeDao {
    public String addEmployee(Employee employee);
    public Employee searchEmployee(int employeeId);
    public List<Employee> searchEmployees();
    public String updateEmployee(Employee employee);
    public String deleteEmployee(int employeeId);
}
