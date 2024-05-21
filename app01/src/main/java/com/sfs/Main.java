package com.sfs;

import com.sfs.beans.Employee;
import com.sfs.dao.EmployeeDao;
import com.sfs.dao.EmployeeDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Config.xml");
        EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");

/*--------------- Insert Employee------------------------------------------ */
//        Employee employee = new Employee();
//        employee.setEno(444);
//        employee.setEname("Darshan");
//        employee.setEsal(8000);
//        employee.setEaddr("Ambernath");
//
//        String status = employeeDao.addEmployee(employee);
//        System.out.println(status);

/*---------------------Get Particular Employee--------------------------------*/
//        Employee emp = employeeDao.searchEmployee(333);
//        if (emp != null) {
//            System.out.println("Employee Details");
//            System.out.println("==============================");
//            System.out.println("Employee Number        : "+emp.getEno());
//            System.out.println("Employee Name          : "+emp.getEname());
//            System.out.println("Employee Salary        : "+emp.getEsal());
//            System.out.println("Employee Address       : "+emp.getEaddr());
//        }else {
//           System.out.println("Employee Does Exist");
//        }
/*--------------------- Fetch All Employee ------------------------------- */
//        List<Employee> employees = employeeDao.searchEmployees();
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }

/*-------------------Update Employee----------------------------------------*/
//        Employee employee = new Employee();
//        employee.setEno(333);
//        employee.setEname("Sonu Gunjal");
//        employee.setEsal(8500);
//        employee.setEaddr("Mumbai");
//
//        String status = employeeDao.updateEmployee(employee);
//        System.out.println(status);

/*------------------- Delete Employee ---------------------------------------*/
        String status = employeeDao.deleteEmployee(444);
        System.out.println(status);

    }
}