package com.erp.academia_3_4.bean;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Specialization")
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialization_id")
    private int specializationID;

    @Column(nullable = false,unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column()
    private String description;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private float creditsRequirement;

//    @ManyToMany(mappedBy = "specialization")
//    private List<Course> courseList;

    public  Specialization(){
    }

//    }
//    public List<Course> getCourseList() {
//        return courseList;
//    }
//
//    public void setCourseList(List<Course> courseList) {
//        this.courseList = courseList;
//    }

    public int getSpecializationID() {
        return specializationID;
    }

    public void setSpecializationID(int specializationID) {
        this.specializationID = specializationID;
    }

    public float getCreditsRequirement() {
        return creditsRequirement;
    }

    public void setCreditsRequirement(float creditsRequirement) {
        this.creditsRequirement = creditsRequirement;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
