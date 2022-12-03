package com.erp.academia_3_4.dao.impl;

import com.erp.academia_3_4.bean.Employee;
import com.erp.academia_3_4.bean.Student;
import com.erp.academia_3_4.dao.StudentDAO;
import com.erp.academia_3_4.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public Student getStudentDetailsById(Integer id) {
        Session session = HibernateSessionUtil.getSession();
        try {
            return session.get(Student.class, id);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<Student> getStudentList(Integer id) {

        List<Student> studentList = new ArrayList<>();
        try (Session session = HibernateSessionUtil.getSession()) {
            for (
                    final Object student : session
                    .createQuery("FROM Student s join Student_Course sc on s.student_id = sc.student.student_id where sc.course.courseID = :id")
                    .setParameter("id", id).list()
            )
                studentList.add((Student) student);
        } catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }

        return studentList;
    }
}
