package com.erp.academia_3_4.bean;

import jakarta.persistence.*;
import jakarta.json.bind.annotation.JsonbTransient;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseID;

    @Column(name = "course_code",nullable = false,unique = true)
    private String courseCode;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private String term;

    @Column(nullable = false)
    private float credits;

    @Column(nullable = false)
    private Integer capacity;

    @Column()
    private String description;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "course",fetch = FetchType.EAGER)
    private List<Course_Schedule> courseScheduleList;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Course_Specialization",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "specialization_id")})
    private List<Specialization> specializationList;

    public Course(){}

    public List<Specialization> getSpecializationList() {
        return specializationList;
    }

    public void setSpecializationList(List<Specialization> specializationList) {
        this.specializationList = specializationList;
    }

    public List<Course_Schedule> getCourseSchedules() {
        return courseScheduleList;
    }

    public void setCourseSchedules(List<Course_Schedule> courseScheduleList) {
        this.courseScheduleList = courseScheduleList;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public float getCredits() {
        return credits;
    }

    public void setCredits(float credits) {
        this.credits = credits;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
