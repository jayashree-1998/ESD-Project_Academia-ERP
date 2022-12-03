package com.erp.academia_3_4.dao;

import com.erp.academia_3_4.bean.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee login(Employee employee);

    public abstract List<Employee> getAllEmployeeDetails();

    public abstract Employee getEmployeeDetailsById(Integer id);

}

