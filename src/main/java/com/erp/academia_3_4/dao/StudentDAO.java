package com.erp.academia_3_4.dao;

import com.erp.academia_3_4.bean.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> getStudentList(Integer id);
    public Student getStudentDetailsById(Integer id);
}
