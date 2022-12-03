package com.erp.academia_3_4.dao;

import com.erp.academia_3_4.bean.Department;

import java.util.List;

public interface DepartmentDAO {
    List<Department> getDepartment();
    Department getDepartmentById(Integer id);
}

