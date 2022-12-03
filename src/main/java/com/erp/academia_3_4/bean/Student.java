package com.erp.academia_3_4.bean;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;

    @Column(unique = true,nullable = false)
    private String roll_number;

    @Column(nullable = false)
    private String first_name;

    @Column
    private String last_name;

    @Column(nullable = false,unique = true)
    private String email;

    @Column
    private String photograph_path;

    @Column(nullable = false)
    @ColumnDefault(value = "0.0")
    private float cgpa;

    @Column(nullable = false)
    private Integer total_credits;

    @Column
    private String graduation_year;

    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    public Student() {

    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotograph_path() {
        return photograph_path;
    }

    public void setPhotograph_path(String photograph_path) {
        this.photograph_path = photograph_path;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public Integer getTotal_credits() {
        return total_credits;
    }

    public void setTotal_credits(Integer total_credits) {
        this.total_credits = total_credits;
    }

    public String getGraduation_year() {
        return graduation_year;
    }

    public void setGraduation_year(String graduation_year) {
        this.graduation_year = graduation_year;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }


}
