package com.erp.academia_3_4.service;

import com.erp.academia_3_4.bean.Employee;
import com.erp.academia_3_4.dao.impl.EmployeeDAOImpl;

import java.util.List;

public class EmployeeService {

    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

    public Employee login(Employee employee) {
        Employee loggedInEmployee = employeeDAO.login(employee);

        // If no login happens, then return null
        if (loggedInEmployee == null)
            return null;

        return loggedInEmployee;

    }

    public Employee fetchEmployeeDetailsById(Integer id){
        return employeeDAO.getEmployeeDetailsById(id);
    }

    public List<Employee> getAllEmployeeDetails(){
        return employeeDAO.getAllEmployeeDetails();
    }
}
