package com.erp.academia_3_4.bean;

import jakarta.persistence.*;


@Entity
@Table(name = "Student_Course")
public class Student_Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer std_course_id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Student_Course() {

    }

    public Integer getStd_course_id() {
        return std_course_id;
    }

    public void setStd_course_id(Integer std_course_id) {
        this.std_course_id = std_course_id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
