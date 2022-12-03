package com.erp.academia_3_4.dao.impl;

import com.erp.academia_3_4.bean.Employee;
import com.erp.academia_3_4.dao.EmployeeDAO;
import com.erp.academia_3_4.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;


public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public Employee login(Employee employee) {
        try (Session session = HibernateSessionUtil.getSession()){
            String employeeEmail = employee.getEmail();
            String employeePassword = employee.getPassword();

            List<Object> result = new ArrayList<Object>(
                    session.createQuery(
                                    "FROM Employee WHERE email = :email and password = :password"
                            )
                            .setParameter("email", employeeEmail)
                            .setParameter("password", employeePassword)
                            .list()
            );

            // If no valid Employee found, return null so that login failure is understood
            if (result.size() == 0)
                return null;
            else {
                Employee emp = (Employee) result.get(0);

                if (emp.getDepartment().getDepartmentID() == 2)
                    return emp;
                else
                    return null;
            }

        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return null;
    }

    @Override
    public List<Employee> getAllEmployeeDetails() {
        Session session = HibernateSessionUtil.getSession();
        List<Employee> employees = new ArrayList<>();
        try {
            for (final Object faculty : session.createQuery("from Employee ").list()) {
                employees.add((Employee) faculty);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return employees;
    }

    @Override
    public Employee getEmployeeDetailsById(Integer id) {
        Session session = HibernateSessionUtil.getSession();
        try {
            return session.get(Employee.class, id);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

}

