package com.erp.academia_3_4.dao.impl;

import com.erp.academia_3_4.bean.Department;
import com.erp.academia_3_4.dao.DepartmentDAO;
import com.erp.academia_3_4.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {

    @Override
    public List<Department> getDepartment() {
        return null;
    }

    @Override
    public Department getDepartmentById(Integer id) {
        Session session = HibernateSessionUtil.getSession();
        try {
            return session.get(Department.class, id);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }
}
