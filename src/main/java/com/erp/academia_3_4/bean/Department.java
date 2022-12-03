package com.erp.academia_3_4.bean;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Department")
public class Department {

    @Id
    @Column(name ="department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentID;

    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private int capacity;


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartmentID() {
        return departmentID;
    }
    public  Department(){

    }
    public  Department(String name,int capacity){
        this.capacity = capacity;
        this.name = name;
    }
    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

}
