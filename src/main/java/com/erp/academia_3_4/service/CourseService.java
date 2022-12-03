package com.erp.academia_3_4.service;

import com.erp.academia_3_4.bean.Course;
import com.erp.academia_3_4.dao.impl.EmployeeDAOImpl;

import java.util.List;

public class CourseService {

    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
    public List<Course> getCoursesByFaculty(Integer faculty_id) {
        return employeeDAO.getEmployeeDetailsById(faculty_id).getCourses();
    }

}
