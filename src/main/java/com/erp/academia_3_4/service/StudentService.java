package com.erp.academia_3_4.service;

import com.erp.academia_3_4.bean.Student;
import com.erp.academia_3_4.dao.impl.StudentDAOImpl;

import java.util.List;

public class StudentService {

    StudentDAOImpl studentDAO = new StudentDAOImpl();

    public Student fetchStudentById(Integer student_id){
        return studentDAO.getStudentDetailsById(student_id);
    }

    public List<Student> getStudentsByCourseId(Integer courseid) {
        List<Student> studentList = studentDAO.getStudentList(courseid);
        return studentList;
    }

}
